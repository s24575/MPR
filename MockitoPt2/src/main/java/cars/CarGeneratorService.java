package cars;

import java.util.Locale;

public class CarGeneratorService {
    private CarGenerator carGenerator;

    public Car generateCar(String make, String color) {
        return carGenerator.generateCar(make.toUpperCase(), color, generatePlate());
    }

    private String generatePlate() {
        int digit1 = (int) (Math.random() * 10);
        int digit2 = (int) (Math.random() * 10);
        int digit3 = (int) (Math.random() * 10);
        int digit4 = (int) (Math.random() * 10);

        return "GDA" + digit1 + digit2 + digit3 + digit4;
    }
}
