package vendingmachine.domain;

public class Price {
    private static final String INVALID_AMOUNT_PRICE_MESSAGE = "[ERROR] 상품 가격이 적절하지 않습니다";
    private static final int MIN_PRICE = 100;
    private static final int PRICE_UNIT = 10;
    private final int amount;

    public Price(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    private void validate(int price) {
        validateRange(price);
        validateUnit(price);
    }

    private void validateRange(int price) {
        if (price < MIN_PRICE) {
            throw new IllegalArgumentException(INVALID_AMOUNT_PRICE_MESSAGE);
        }
    }

    private void validateUnit(int price) {
        if (price % PRICE_UNIT != 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT_PRICE_MESSAGE);
        }
    }
}
