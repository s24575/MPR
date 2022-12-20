package message;

public class EncodingMethod {
    private int amount;
    private final ShiftDirection direction;

    public EncodingMethod(int amount, ShiftDirection direction) {
        this.amount = amount;
        this.direction = direction;
    }

    public int getAmount() {
        return amount;
    }

    public EncodingMethod setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public ShiftDirection getDirection() {
        return direction;
    }

}
