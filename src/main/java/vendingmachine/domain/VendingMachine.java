package vendingmachine.domain;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private static final String NOT_ENOUGH_INPUT_MESSAGE = "[ERROR] 투입 금액이 충분하지 않습니다";
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

    public Coins getCoins() {
        return coins;
    }

    public Item getItem(String name) {
        return items.getItem(name);
    }

    public boolean isMoneyCanAffordAtLeastOneItem(Money inputMoney) {
        return inputMoney.isAffordable(cheapestItemPrice());
    }

    public Price cheapestItemPrice() {
        return items.cheapestPrice();
    }

    public void purchaseItem(Money inputMoney, String itemName) {
        Item item = getItem(itemName);
        if (!inputMoney.isAffordable(item.getPrice())) {
            throw new IllegalArgumentException(NOT_ENOUGH_INPUT_MESSAGE);
        }
        inputMoney.subtract(item.getPrice());
    }

    public Coins getChange() {
        Coin coin;
        Map<Coin, Integer> coinCountMap = new HashMap<>();
        while ((coin = coins.getMostValuableCoinLessThanMoney(money)) != null) {
            coinCountMap.put(coin, coinCountMap.getOrDefault(coin, 0) + 1);
            money.subtract(new Price(coin.getAmount()));
        }
        return new Coins(coinCountMap);
    }
}
