package lotto.domain;

import lotto.constant.LotteryRank;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLotteryTest {
    private static WinningLottery winningLottery;

    @BeforeAll
    static void beforeAll() {
        BonusNumber bonusNumber = new BonusNumber(7);
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        winningLottery = new WinningLottery(bonusNumber, winningNumbers);
    }

    @Test
    void Evaluate_First_Rank() {
        List<Integer> lotteryNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThat(winningLottery.evaluate(lotteryNumbers)).isEqualTo(LotteryRank.FIRST);
    }

    @Test
    void Evaluate_Second_Rank() {
        List<Integer> lotteryNumbers = List.of(1, 2, 3, 4, 5, 7);
        assertThat(winningLottery.evaluate(lotteryNumbers)).isEqualTo(LotteryRank.SECOND);
    }

    @Test
    void Evaluate_Third_Rank() {
        List<Integer> lotteryNumbers = List.of(1, 2, 3, 4, 5, 8);
        assertThat(winningLottery.evaluate(lotteryNumbers)).isEqualTo(LotteryRank.THIRD);
    }

    @Test
    void Evaluate_Fourth_Rank() {
        List<Integer> lotteryNumbers = List.of(1, 20, 3, 4, 10, 6);
        assertThat(winningLottery.evaluate(lotteryNumbers)).isEqualTo(LotteryRank.FOURTH);
    }

    @Test
    void Evaluate_Fifth_Rank() {
        List<Integer> lotteryNumbers = List.of(13, 2, 30, 41, 5, 6);
        assertThat(winningLottery.evaluate(lotteryNumbers)).isEqualTo(LotteryRank.FIFTH);
    }

    @Test
    void Evaluate_Lose_With_Two_Matches_Rank() {
        List<Integer> lotteryNumbers = List.of(18, 27, 33, 41, 5, 6);
        assertThat(winningLottery.evaluate(lotteryNumbers)).isEqualTo(LotteryRank.LOSE_WITH_TWO_MATCHES);
    }

    @Test
    void Evaluate_Lose_With_One_Match_Rank() {
        List<Integer> lotteryNumbers = List.of(1, 21, 13, 41, 17, 26);
        assertThat(winningLottery.evaluate(lotteryNumbers)).isEqualTo(LotteryRank.LOSE_WITH_ONE_MATCH);
    }

    @Test
    void Evaluate_Lose_With_No_Match_Rank() {
        List<Integer> lotteryNumbers = List.of(14, 21, 13, 41, 17, 26);
        assertThat(winningLottery.evaluate(lotteryNumbers)).isEqualTo(LotteryRank.LOSE_WITH_NO_MATCH);
    }
}
