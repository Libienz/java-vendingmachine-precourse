package vendingmachine.domain;

import java.util.Map;

public class VendingMachine {
    private final Map<Coin, Integer> coins;
    private final Items items;
    private final Money money;

    public VendingMachine(Map<Coin, Integer> coins, Items items, Money money) {
        this.coins = coins;
        this.items = items;
        this.money = money;
    }

    public Map<Coin, Integer> getCoins() {
        return coins;
    }

    public Items getItems() {
        return items;
    }

    public Money getMoney() {
        return money;
    }
}
