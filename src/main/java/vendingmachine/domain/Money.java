package vendingmachine.domain;

public class Money {
    private static final String INVALID_RANGE_MONEY_MESSAGE = "[ERROR] 범위가 올바르지 않습니다";
    private static final int MIN = 0;
    private int value;

    public Money(int value) {
        validate(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isAffordable(Price price) {
        return value >= price.getAmount();
    }

    public void subtract(Price price) {
        value -= price.getAmount();
    }

    public void add(Money money) {
        value += money.getValue();
    }

    private void validate(int value) {
        validateRange(value);
    }

    private void validateRange(int value) {
        if (value < MIN) {
            throw new IllegalArgumentException(INVALID_RANGE_MONEY_MESSAGE);
        }
    }
}
