package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자판기 판매 물품 테스트")
class ItemTest {

    @Test
    @DisplayName("Item 판매 시 수량 감소 테스트")
    void saleItem() {
        Item item = new Item("사이다", new Price(1000), 10);
        item.sale();
        assertThat(item.getQuantity()).isEqualTo(9);
    }
}