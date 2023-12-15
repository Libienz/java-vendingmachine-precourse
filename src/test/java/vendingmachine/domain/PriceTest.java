package vendingmachine.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("상품 가격 테스트")
class PriceTest {
    @ParameterizedTest
    @ValueSource(ints = {100, 200, 310})
    @DisplayName("유효한 가격으로 Price 객체 생성")
    void createPriceWithValidAmount(int amount) {
        assertThatNoException().isThrownBy(() -> new Price(amount));
    }

    @ParameterizedTest
    @ValueSource(ints = {80, 80, 99})
    @DisplayName("최소 가격보다 낮은 금액으로 Price 객체 생성 시 예외 발생")
    void throwExceptionWhenAmountBelowMinimum(int amount) {
        assertThatThrownBy(() -> new Price(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 상품 가격이 적절하지 않습니다");
    }

    @ParameterizedTest
    @ValueSource(ints = {11, 21, 35})
    @DisplayName("10원 단위가 아닌 금액으로 Price 객체 생성 시 예외 발생")
    void throwExceptionWhenAmountNotMultipleOfTen(int amount) {
        int invalidAmount = 105;
        assertThatThrownBy(() -> new Price(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 상품 가격이 적절하지 않습니다");
    }

}