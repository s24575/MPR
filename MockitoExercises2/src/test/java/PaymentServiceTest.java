import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import payment.Payment;
import payment.PaymentRepository;
import payment.PaymentService;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceTest {
    @Mock
    PaymentRepository paymentRepository;
    @Mock
    Payment payment;

    @Test(expected = RuntimeException.class)
    public void savePaymentTestZero(){
        PaymentService paymentService = new PaymentService(paymentRepository);
        Mockito.when(payment.getAmount()).thenReturn(0);
        paymentService.savePayment(payment);
    }
}
