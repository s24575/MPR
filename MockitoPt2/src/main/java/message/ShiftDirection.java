package message;

public enum ShiftDirection {
    FORWARD(1), BACKWARD(-1);

    private final int val;

    ShiftDirection(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}
