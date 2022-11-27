package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {
    @Test
    void When_NoMoney_Expect_IllegalArgumentException() {
        assertThatThrownBy(() -> new Money(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("돈을 투입");
    }

    @ParameterizedTest (name = "{index}) money = {0}")
    @ValueSource(ints = {1, 123, 1001, 10100, 23456})
    void When_InvalidUnitOfMoney_Expect_IllegalArgumentException(int money) {
        assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("1000원 단위");
    }

    @ParameterizedTest (name = "{index}) money = {0}")
    @ValueSource(ints = {1000, 10000, 15000, 100000, 49000})
    void When_ValidUnitOfMoney_Expect_NoException(int money) {
        assertThatCode(() -> new Money(money))
                .doesNotThrowAnyException();
    }
}
