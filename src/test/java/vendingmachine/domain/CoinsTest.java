package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("보유 중인 동전 테스트")
class CoinsTest {
    private Coins coins;

    @BeforeEach
    void setUp() {
        Map<Coin, Integer> coinMap = new EnumMap<>(Coin.class);
        coinMap.put(Coin.COIN_500, 1);
        coinMap.put(Coin.COIN_100, 2);
        coinMap.put(Coin.COIN_50, 3);
        coinMap.put(Coin.COIN_10, 4);
        coins = new Coins(coinMap);
    }

    @Test
    @DisplayName("동전 개수 반환 테스트")
    void testGetCoinCount() {
        assertThat(coins.getCoinCount(Coin.COIN_100)).isEqualTo(2);
    }

    @Test
    @DisplayName("주어진 금액 이하의 가장 가치 있는 동전 반환 테스트")
    void testGetMostValuableCoinLessThanMoney() {
        Coin coin = coins.getMostValuableCoinLessThanMoney(new Money(150));
        assertThat(coin).isEqualTo(Coin.COIN_100);
    }

    @Test
    @DisplayName("가능한 동전이 없는 경우 null 반환 테스트")
    void testReturnNullWhenNoAvailableCoin() {
        Coin coin = coins.getMostValuableCoinLessThanMoney(new Money(5));
        assertThat(coin).isNull();
    }
}