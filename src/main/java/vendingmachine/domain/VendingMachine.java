package vendingmachine.domain;

import java.util.Map;

public class VendingMachine {
    private final Coins coins;
    private final Items items;

    public VendingMachine(Coins coins, Items items) {
        this.coins = coins;
        this.items = items;
    }

    public Items getItems() {
        return items;
    }

    public Coins getCoins() {
        return coins;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }
}
