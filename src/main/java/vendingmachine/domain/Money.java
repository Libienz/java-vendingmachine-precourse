package vendingmachine.domain;

public class Money {
    private int value;

    public Money(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isAffordable(Price price) {
        return value > price.getAmount();
    }

    public void subtract(Price price) {
        value -= price.getAmount();
    }
}
