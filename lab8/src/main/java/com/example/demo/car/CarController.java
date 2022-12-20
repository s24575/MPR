package com.example.demo.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
//@RequestMapping("cars-rest")
public class CarController {
    private CarService carService;

    protected CarController() {}

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars/show")
    public String showCars(Model model){
        System.out.println("SHOW CARS");
        model.addAttribute("cars", carService.getCarRepository().findAll());
        return "showCars";
    }

    @GetMapping("/cars/add")
    public String addCar(Model model){
        System.out.println("GET CAR");
        model.addAttribute("car", new Car());
        return "addCarForm";
    }

    @PostMapping("/cars/add")
    public String saveCar(@ModelAttribute Car car, BindingResult errors, Model model) {
        System.out.println("POST CAR");
        carService.getCarRepository().save(car);
        model.addAttribute("car", new Car());
        return "addCarForm";
    }

    @GetMapping("/cars/update")
    public String updateCar(Model model){
        System.out.println("UPDATE CAR");
        model.addAttribute("car", new Car());
        return "updateCarForm";
    }

    @PostMapping("/cars/update")
    public String saveCar(@ModelAttribute Car car, BindingResult errors, Model model) {
        System.out.println("POST CAR");
        carService.getCarRepository().save(car);
        model.addAttribute("car", new Car());
        return "addCarForm";
    }

    @GetMapping(value = "/id/{id}", produces = "application/json")
    public Optional<Car> getCar(@PathVariable Long id){
        return carService.getCarRepository().findById(id);
    }

    @GetMapping(value = "/make/{make}", produces = "application/json")
    public List<Car> getByMake(@PathVariable String make){
        return carService.getCarRepository().findAllByMake(make);
    }

    @GetMapping(value = "/registration/{registration}", produces = "application/json")
    public Car getByRegistration(@PathVariable String registration){
        return carService.getCarRepository().findByRegistration(registration);
    }

    @PostMapping(value = "/create")
    public void postCar(Car car){
        carService.getCarRepository().save(car);
    }

//    @PatchMapping(value = "/patch")
//    public void patchCar(){
//
//    }
}
