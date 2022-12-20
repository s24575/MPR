package cars;

public class Car {
    private String make;
    private String color;
    private String registration;

    public String getMake() {
        return make;
    }

    public Car setMake(String make) {
        this.make = make;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Car setColor(String color) {
        this.color = color;
        return this;
    }

    public String getRegistration() {
        return registration;
    }

    public Car setRegistration(String registration) {
        this.registration = registration;
        return this;
    }
}
