package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private static final String NO_SUCH_COIN_MESSAGE = "[ERROR] 해당하는 동전을 찾을 수 없습니다";
    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public static List<Integer> amountValues() {
        return Arrays.stream(Coin.values())
                .map(Coin::getAmount)
                .collect(Collectors.toList());
    }

    public static Coin from(int amount) {
        return Arrays.stream(Coin.values())
                .filter(coin -> coin.getAmount() == amount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NO_SUCH_COIN_MESSAGE));
    }

    public int getAmount() {
        return amount;
    }
}
