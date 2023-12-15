package vendingmachine.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("금액 테스트")
class MoneyTest {
    @ParameterizedTest
    @ValueSource(ints = {100, 200, 300})
    @DisplayName("유효한 금액으로 Money 객체 생성")
    void createMoneyWithValidAmount(int amount) {
        assertThatNoException().isThrownBy(() -> new Money(amount));
    }

    @ParameterizedTest
    @ValueSource(ints = {-100, -1,})
    @DisplayName("유효하지 않은 금액으로 Money 객체 생성 시 예외 발생")
    void throwExceptionWhenInvalidAmount(int amount) {
        assertThatThrownBy(() -> new Money(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 범위가 올바르지 않습니다");
    }

    @Test
    @DisplayName("금액이 충분한지 확인")
    void isAffordable() {
        Money money = new Money(1000);
        Price price = new Price(500);

        assertThat(money.isAffordable(price)).isTrue();
        assertThat(money.isAffordable(new Price(1500))).isFalse();
    }

    @Test
    @DisplayName("금액 차감 테스트")
    void subtractMoney() {
        Money money = new Money(1000);
        money.subtract(new Price(500));

        assertThat(money.getValue()).isEqualTo(500);
    }

    @Test
    @DisplayName("금액 추가 테스트")
    void addMoney() {
        Money money = new Money(1000);
        money.add(new Money(500));

        assertThat(money.getValue()).isEqualTo(1500);
    }
}