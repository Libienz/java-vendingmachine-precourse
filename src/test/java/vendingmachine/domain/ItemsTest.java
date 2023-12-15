package vendingmachine.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("판매 정보 테스트")
class ItemsTest {
    @Test
    @DisplayName("제품 이름으로 특정 Item 반환 테스트")
    void getItemByName() {
        Items items = new Items(Arrays.asList(
                new Item("콜라", new Price(1500), 20),
                new Item("사이다", new Price(1000), 10)
        ));
        assertThat(items.getItem("콜라").getName()).isEqualTo("콜라");
    }

    @Test
    @DisplayName("해당하는 제품이 없을 경우 예외처리 테스트")
    void noSuchItemNameTest() {
        Items items = new Items(Arrays.asList(
                new Item("콜라", new Price(1500), 20),
                new Item("사이다", new Price(1000), 10)
        ));
        assertThatThrownBy(() -> items.getItem("환타"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 해당하는 상품을 찾을 수 없습니다");
    }

    @Test
    @DisplayName("가장 저렴한 아이템 가격 반환 테스트")
    void getCheapestPrice() {
        Items items = new Items(Arrays.asList(
                new Item("콜라", new Price(1500), 20),
                new Item("사이다", new Price(1000), 10)
        ));

        assertThat(items.cheapestPrice().getAmount()).isEqualTo(1000);
    }

    @Test
    @DisplayName("모든 아이템 재고 없음 확인 테스트")
    void hasNoItems() {
        Items items = new Items(Arrays.asList(
                new Item("콜라", new Price(1500), 0),
                new Item("사이다", new Price(1000), 0)
        ));

        assertThat(items.hasNoItem()).isTrue();
    }
}