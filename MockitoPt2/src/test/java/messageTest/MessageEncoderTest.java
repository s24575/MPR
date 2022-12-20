package messageTest;

import message.EncodingMethod;
import message.Message;
import message.MessageEncoder;
import message.ShiftDirection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MessageEncoderTest {
    @Mock
    EncodingMethod encodingMethod;

    @Test
    public void encodeTest(){
        Mockito.when(encodingMethod.getAmount()).thenReturn(2);
        Mockito.when(encodingMethod.getDirection()).thenReturn(ShiftDirection.FORWARD);

        MessageEncoder messageEncoder = new MessageEncoder(encodingMethod);

        Message message = new Message("test");
        Message output = messageEncoder.encode(message);

        System.out.println(output);

        Assert.assertEquals("vguv", output.getText());
    }
}
