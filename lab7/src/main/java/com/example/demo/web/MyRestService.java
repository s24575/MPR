package com.example.demo.web;

import com.example.demo.Car;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyRestService {
    private List<Car> cars;

    public MyRestService(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
