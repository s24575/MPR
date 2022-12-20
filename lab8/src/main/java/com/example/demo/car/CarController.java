package com.example.demo.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cars-rest")
public class CarController {
    private CarService carService;

    protected CarController() {}

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
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
