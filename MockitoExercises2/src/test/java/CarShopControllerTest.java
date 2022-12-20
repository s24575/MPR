import car.Car;
import car.CarService;
import client.ClientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import payment.Payment;
import payment.PaymentService;

@RunWith(MockitoJUnitRunner.class)
public class CarShopControllerTest {
    @Mock
    ClientService clientService;
    @Mock
    CarService carService;
    @Mock
    PaymentService paymentService;
    @Mock
    Car car;

    @Test(expected = RuntimeException.class)
    public void createNewClientTest(){
        Mockito.when(car).thenReturn(null);
        CarShopController carShopController = new CarShopController(clientService, carService, paymentService);
        //createNewClient();
        // create response and compare to function
    }
}
