package com.example.demo.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository){
        this.carRepository = carRepository;
        carRepository.save(new Car("Audi", "ABCDE"));
        carRepository.save(new Car("Audi", "ABABA"));
        carRepository.save(new Car("Fiat", "EDCBA"));
        Car car1 = carRepository.findByRegistration("ABCDE");
        List<Car> car2 = carRepository.findAllByMake("Audi");
    }

    public CarRepository getCarRepository() {
        return carRepository;
    }
}
