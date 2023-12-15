package vendingmachine.dto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Coins;

public class CoinsDto {
    private final Map<Integer, Integer> coinValueCountMap;

    private CoinsDto(Map<Integer, Integer> coinValueCountMap) {
        this.coinValueCountMap = coinValueCountMap;
    }

    public static CoinsDto from(Coins coins) {
        Map<Integer, Integer> coinValueCountMap = Arrays.stream(Coin.values())
                .collect(Collectors.toMap(
                        Coin::getAmount,
                        coins::getCoinCount
                ));
        return new CoinsDto(coinValueCountMap);
    }

    public Map<Integer, Integer> getCoinValueCountMap() {
        return coinValueCountMap;
    }
}
