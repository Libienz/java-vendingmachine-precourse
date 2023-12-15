package vendingmachine.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VendingMachineTest {
    private VendingMachine vendingMachine;
    private Item testItem1;
    private Item testItem2;
    private Money inputMoney;

    @BeforeEach
    void setUp() {
        testItem1 = new Item("콜라", new Price(1500), 10);
        testItem2 = new Item("사이다", new Price(15000), 10);
        Items items = new Items(List.of(testItem1, testItem2));

        Map<Coin, Integer> coinCount = new EnumMap<>(Coin.class);
        coinCount.put(Coin.COIN_500, 5);
        coinCount.put(Coin.COIN_50, 5);
        coinCount.put(Coin.COIN_100, 5);
        coinCount.put(Coin.COIN_10, 5);
        Coins coins = new Coins(coinCount);

        inputMoney = new Money(2000);

        vendingMachine = new VendingMachine(coins, items, inputMoney);
    }

    @Test
    @DisplayName("아이템 구매 후 잔액 감소 검증")
    void purchaseItem() {
        vendingMachine.purchaseItem("콜라");
        assertThat(vendingMachine.getRemainMoney()).isEqualTo(500);
    }

    @Test
    @DisplayName("충분하지 않은 금액으로 아이템 구매 시 예외 발생 검증")
    void purchaseWithNotEnoughMoney() {
        vendingMachine.addMoney(new Money(500));
        assertThatThrownBy(() -> vendingMachine.purchaseItem("사이다"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 투입 금액이 충분하지 않습니다");
    }

    @Test
    @DisplayName("잔액 반환 시 적절한 동전 반환 검증")
    void getChange() {
        vendingMachine.purchaseItem("콜라");
        Coins change = vendingMachine.getChange();
        assertThat(change.getCoinCount(Coin.COIN_500)).isEqualTo(1);
    }

    @Test
    @DisplayName("아이템이 없거나 잔액이 충분하지 않을 때 자동 반환 조건 검증")
    void changeReturnCondition() {
        assertThat(vendingMachine.changeReturnCondition()).isFalse();
        vendingMachine.purchaseItem("콜라");
        assertThat(vendingMachine.changeReturnCondition()).isTrue();
    }
}