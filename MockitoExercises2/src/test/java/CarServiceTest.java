import car.Car;
import car.CarCreator;
import car.CarService;
import client.Client;
import client.ClientRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import payment.Payment;
import payment.PaymentRepository;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {
     @Mock
    Payment payment;
     @Mock
     CarCreator carCreator;
     @Mock
    ClientRepository clientRepository;
     @Mock
     PaymentRepository paymentRepository;

    @Test
    public void registerClientCarTest() {
        CarService carService = new CarService(carCreator, clientRepository, paymentRepository);
        Car car = new Car();
        car.setColor("auto");
        car.setMake("czarne");
        car.setPlate("12345");
        Mockito.when(carCreator.createCar("auto", "czarne", "12345")).thenReturn(car);
        Client client = new Client();
        client.setId("1");
        Mockito.when(clientRepository.findClient("1")).thenReturn(client);
        Client client1 = carService.registerClientCar("1", "auto", "czarne", "12345");
        Assert.assertEquals(client.getId(), client1.getId());
        Assert.assertEquals(car.getPlate(), client1.getCar().getPlate());
    }

     @Test(expected = RuntimeException.class)
    public void savePaymentTest() {
        Mockito.when(payment.getAmount()).thenReturn(0);
        CarService carService = new CarService(carCreator, clientRepository, paymentRepository);
        carService.savePayment(payment);
    }
}
