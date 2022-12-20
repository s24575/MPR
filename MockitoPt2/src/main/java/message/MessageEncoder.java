package message;

public class MessageEncoder {
    private final EncodingMethod encodingMethod;

    public MessageEncoder(EncodingMethod encodingMethod) {
        this.encodingMethod = encodingMethod;
    }

    public Message encode(Message message) {
        StringBuilder encodedMessage = new StringBuilder();
        for (char character : message.getText().toCharArray()) {
            encodedMessage.append((char)(character + (encodingMethod.getAmount() * encodingMethod.getDirection().getVal())));
        }
        message.setText(encodedMessage.toString());

        return message;
    }
}
