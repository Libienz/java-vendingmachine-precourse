package vendingmachine.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class Coins {
    private final Map<Coin, Integer> coins;

    public Coins(Map<Coin, Integer> coins) {
        this.coins = coins;
    }

    public int getCoinCount(Coin coin) {
        return coins.getOrDefault(coin, 0);
    }

    public Coin getMostValuableCoinLessThanMoney(Money money) {
        for (Coin coin : Coin.values()) {
            if (coin.getAmount() <= money.getValue() && coins.getOrDefault(coin, 0) != 0) {
                return coin;
            }
        }
        return null;
    }
}
