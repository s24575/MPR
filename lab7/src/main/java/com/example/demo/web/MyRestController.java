package com.example.demo.web;

import com.example.demo.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
public class MyRestController {
    MyRestService myRestService;

    @Autowired
    public MyRestController(MyRestService myRestService) {
        this.myRestService = myRestService;
    }

    @GetMapping(path = "/car/{id}")
    public Car getCar(@PathVariable int id){
        return myRestService.getCars().get(id - 1);
    }

    @GetMapping(path = "/cars")
    public List<Car> getCars(){
        return myRestService.getCars();
    }

    @PostMapping("/car/create")
    @ResponseBody
    public void post(@RequestBody Car car){

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable int id){
        List<Car> cars = myRestService.getCars();
        Iterator<Car> i = cars.iterator();
        while(i.hasNext()){
            if(i.next().getId() == id){
                i.remove();
                break;
            }
        }
    }
}
