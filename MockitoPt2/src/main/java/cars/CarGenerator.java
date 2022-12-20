package cars;

public class CarGenerator {
    public Car generateCar(String make, String color, String registration) {
        Car car = new Car();
        car.setMake(make);
        car.setColor(color);
        car.setRegistration(registration);
        return car;
    }
}
