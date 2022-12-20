package com.example.demo;


public class Car {
    private int id;
    private String make;
    private String color;

    public Car(int id, String make, String color) {
        this.id = id;
        this.make = make;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
