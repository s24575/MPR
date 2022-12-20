package carTest;

import cars.Car;
import cars.CarGenerator;
import cars.CarGeneratorService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CarGeneratorServiceTest {
    @Mock
    CarGenerator carGenerator;
    @InjectMocks
    CarGeneratorService carGeneratorService;

    @Test
    public void generateCarTest(){
        ArgumentCaptor<String> plateCaptor = ArgumentCaptor.forClass(String.class);
        Car car = new Car();
        car.setMake("audi");
        car.setColor("black");

        Mockito.when(carGenerator.generateCar(eq("AUDI"), eq("black"), anyString())).thenReturn(car);

        Car generatedCar = carGeneratorService.generateCar("audi", "black");

        verify(carGenerator).generateCar(eq("AUDI"), eq("black"), anyString());
//        verify(carGenerator).savePlateToDB(plateCaptor.capture());

//        Assert.assertEquals(plateCaptor.getValue().substring(0, 3), "GDA");
    }
}
