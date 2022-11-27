package lotto.domain;

import lotto.constant.LotteryRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryResultTest {
    private static LotteryResult lotteryResult;

    @BeforeEach
    void beforeEach() {
        lotteryResult = new LotteryResult("id");
        lotteryResult.add(LotteryRank.FIFTH);
        lotteryResult.add(LotteryRank.FOURTH);
        lotteryResult.add(LotteryRank.LOSE_WITH_ONE_MATCH);
        lotteryResult.add(LotteryRank.LOSE_WITH_ONE_MATCH);
        lotteryResult.add(LotteryRank.LOSE_WITH_NO_MATCH);
        lotteryResult.add(LotteryRank.LOSE_WITH_TWO_MATCHES);
        lotteryResult.add(LotteryRank.LOSE_WITH_NO_MATCH);
    }

    @Test
    void addResultTest() {
        Map<LotteryRank, Integer> results = Map.of(
                LotteryRank.FIRST, 0,
                LotteryRank.SECOND, 0,
                LotteryRank.THIRD, 0,
                LotteryRank.FOURTH, 1,
                LotteryRank.FIFTH, 1,
                LotteryRank.LOSE_WITH_TWO_MATCHES, 1,
                LotteryRank.LOSE_WITH_ONE_MATCH, 2,
                LotteryRank.LOSE_WITH_NO_MATCH, 2
        );

        assertThat(lotteryResult.getResults()).isEqualTo(results);
    }

    @Test
    void calculateProfitRateTest() {
        double profitRate = lotteryResult.calculateProfitRate();
        assertThat(String.format("%.1f", profitRate)).isEqualTo("785.7");
    }
}
