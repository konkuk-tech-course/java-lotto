package lotto.constant;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LotteryRankTest {
    @ParameterizedTest (name = "{index}) hasBonusNumber = {0}")
    @ValueSource(booleans = {true, false})
    void findFirstRank(boolean hasBonusNumber) {
        assertThat(LotteryRank.find(6, hasBonusNumber))
                .isEqualTo(LotteryRank.FIRST);
    }

    @Test
    void findSecondRank() {
        assertThat(LotteryRank.find(5, true))
                .isEqualTo(LotteryRank.SECOND);
    }

    @Test
    void findThirdRank() {
        assertThat(LotteryRank.find(5, false))
                .isEqualTo(LotteryRank.THIRD);
    }

    @ParameterizedTest (name = "{index}) hasBonusNumber = {0}")
    @ValueSource(booleans = {true, false})
    void findFourthRank(boolean hasBonusNumber) {
        assertThat(LotteryRank.find(4, hasBonusNumber))
                .isEqualTo(LotteryRank.FOURTH);
    }

    @ParameterizedTest (name = "{index}) hasBonusNumber = {0}")
    @ValueSource(booleans = {true, false})
    void findFifthRank(boolean hasBonusNumber) {
        assertThat(LotteryRank.find(3, hasBonusNumber))
                .isEqualTo(LotteryRank.FIFTH);
    }

    @ParameterizedTest (name = "{index}) hasBonusNumber = {0}")
    @ValueSource(booleans = {true, false})
    void findLoseWithTwoMatchesRank(boolean hasBonusNumber) {
        assertThat(LotteryRank.find(2, hasBonusNumber))
                .isEqualTo(LotteryRank.LOSE_WITH_TWO_MATCHES);
    }

    @ParameterizedTest (name = "{index}) hasBonusNumber = {0}")
    @ValueSource(booleans = {true, false})
    void findLoseWithOneMatchRank(boolean hasBonusNumber) {
        assertThat(LotteryRank.find(1, hasBonusNumber))
                .isEqualTo(LotteryRank.LOSE_WITH_ONE_MATCH);
    }

    @ParameterizedTest (name = "{index}) hasBonusNumber = {0}")
    @ValueSource(booleans = {true, false})
    void findLoseWithNoMatchRank(boolean hasBonusNumber) {
        assertThat(LotteryRank.find(0, hasBonusNumber))
                .isEqualTo(LotteryRank.LOSE_WITH_NO_MATCH);
    }
}
