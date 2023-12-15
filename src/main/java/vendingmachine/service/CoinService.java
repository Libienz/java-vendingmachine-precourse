package vendingmachine.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Coins;
import vendingmachine.domain.Money;

public class CoinService {
    public Coins moneyToCoins(Money money) {
        Map<Coin, Integer> coins = new EnumMap<>(Coin.class);
        int remainingAmount = money.getValue();

        while (remainingAmount > 0) {
            Coin randomCoin = getRandomCoin();
            if (randomCoin.getAmount() <= remainingAmount) {
                coins.put(randomCoin, coins.getOrDefault(randomCoin, 0) + 1);
                remainingAmount -= randomCoin.getAmount();
            }
        }

        return new Coins(coins);
    }

    private Coin getRandomCoin() {
        int randomAmount = Randoms.pickNumberInList(Coin.amountValues());
        return Coin.from(randomAmount);
    }
}
