package lotto.view;

import java.util.List;
import lotto.constant.OutputConstant;
import lotto.domain.RankLogic;
import lotto.rank.Ranking;

public class OutputView {


    public static void printStatisTics(double v) {
        System.out.println(OutputConstant.GAME_STATISTIC_ANNONUNCE.message());
        System.out.println(Ranking.RANK_5.getSame() + "개 일치 (5,000원) - " + RankLogic.rankMap.get(Ranking.RANK_5) + "개");
        System.out.println(Ranking.RANK_4.getSame() + "개 일치 (50,000원) - " + RankLogic.rankMap.get(Ranking.RANK_4) + "개");
        System.out.println(Ranking.RANK_3.getSame() + "개 일치 (1,500,000원) - " + RankLogic.rankMap.get(Ranking.RANK_3) + "개");
        System.out.println(Ranking.RANK_3.getSame() + "개 일치, 보너스 볼 일치 (30,000,000원) - " +  RankLogic.rankMap.get(Ranking.RANK_2) + "개");
        System.out.println(Ranking.RANK_1.getSame() + "개 일치 (2,000,000,000원) - " + RankLogic.rankMap.get(Ranking.RANK_1) + "개");
        System.out.println("총 수익률은 "+ String.format("%,.1f",v) + "%입니다.");
    }


    public void printError(String message) {
        System.out.println(message);
    }

    public void printAutoLotto(List<Integer> pickLotto) {
        System.out.println(pickLotto);
    }

    public void printPayMoney() {
        System.out.println(OutputConstant.INPUT_MONEY.message());
    }

    public void printInputWinningLottoTicket() {
        System.out.println(OutputConstant.INPUT_WINNING_LOTTO.message());
    }

    public void printBonusNumber() {
        System.out.println(OutputConstant.INPUT_BONUS.message());
    }

    public void printAmount(int amount) {
        System.out.println(amount+ OutputConstant.PRINT_AMOUNT.message());
    }
}
