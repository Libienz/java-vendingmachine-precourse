package vendingmachine.domain;

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

    public Item getItem(String name) {
        return items.getItem(name);
    }
}
