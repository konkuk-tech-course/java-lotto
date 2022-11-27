package lotto.domain;

import lotto.constant.LotteryRank;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryResultTest {
    @Test
    void addResultTest() {
        LotteryResult lotteryResult = new LotteryResult("id");
        lotteryResult.add(LotteryRank.FIFTH);
        lotteryResult.add(LotteryRank.FIRST);
        lotteryResult.add(LotteryRank.SECOND);
        lotteryResult.add(LotteryRank.LOSE_WITH_ONE_MATCH);
        lotteryResult.add(LotteryRank.SECOND);

        Map<LotteryRank, Integer> results = Map.of(
                LotteryRank.FIRST, 1,
                LotteryRank.SECOND, 2,
                LotteryRank.THIRD, 0,
                LotteryRank.FOURTH, 0,
                LotteryRank.FIFTH, 1,
                LotteryRank.LOSE_WITH_TWO_MATCHES, 0,
                LotteryRank.LOSE_WITH_ONE_MATCH, 1,
                LotteryRank.LOSE_WITH_NO_MATCH, 0
        );

        assertThat(lotteryResult.getResults()).isEqualTo(results);
    }
}
