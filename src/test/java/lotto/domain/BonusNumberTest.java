package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatCode;

public class BonusNumberTest {
    @ParameterizedTest(name = "{index}) input = {0}")
    @ValueSource(ints = { 46, 100, 1000, -1, 0 })
    void When_CreateInvalidRangeNumber_Expect_IllegalArgumentException(int input) {
        assertThatThrownBy(() -> new BonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("보너스")
                .hasMessageContaining("1부터 45까지");
    }

    @ParameterizedTest(name = "{index}) input = {0}")
    @ValueSource(ints = { 1, 10, 11, 45, 33, 22, 37 })
    void When_CreateValidRangeNumber_Expect_NoException(int input) {
        assertThatCode(() -> new BonusNumber(input))
                .doesNotThrowAnyException();
    }
}
