package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatCode;

public class WinningLotteryTest {
    @Test
    void When_WinningNumbersContainBonusNumber_Expect_IllegalArgumentException() {
        BonusNumber bonusNumber = new BonusNumber(7);
        Lotto winningNumbers = new Lotto(List.of(2, 3, 4, 5, 6, 7));
        assertThatThrownBy(() -> new WinningLottery(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("보너스")
                .hasMessageContaining("중복");
    }
}
