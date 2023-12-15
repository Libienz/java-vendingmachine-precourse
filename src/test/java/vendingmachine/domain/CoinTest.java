package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("동전 테스트")
class CoinTest {
    @Test
    @DisplayName("모든 동전 금액 반환 테스트")
    void testAmountValues() {
        List<Integer> amounts = Coin.amountValues();
        assertThat(amounts).containsExactlyInAnyOrder(500, 100, 50, 10);
    }

    @Test
    @DisplayName("금액에 해당하는 동전 반환 테스트")
    void testFromValidAmount() {
        assertThat(Coin.from(500)).isEqualTo(Coin.COIN_500);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 99})
    @DisplayName("잘못된 금액에 대한 예외 테스트")
    void testFromInvalidAmount(int amount) {
        assertThatThrownBy(() -> Coin.from(5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 해당하는 동전을 찾을 수 없습니다");
    }

    @Test
    @DisplayName("동전 금액 반환 테스트")
    void testGetAmount() {
        assertThat(Coin.COIN_100.getAmount()).isEqualTo(100);
    }
}