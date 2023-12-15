package vendingmachine.domain;

import java.util.Map;

public class VendingMachine {
    private final Coins coins;
    private final Items items;
    private final Money money;

    public VendingMachine(Coins coins, Items items, Money money) {
        this.coins = coins;
        this.items = items;
        this.money = money;
    }

    public Items getItems() {
        return items;
    }

    public int getMoney() {
        return money.getValue();
    }

    public boolean contains(String name) {
        return items.contains(name);
    }
}
