package lotto.view;

import lotto.domain.Analyst;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;

import java.util.List;

public class OutputView {
    public void print(String message) {
        System.out.println();
        System.out.println(message);
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto:
                lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printAnalyzedResult(Analyst analyst, LottoGame lottoGame) {
        System.out.println(lottoGame.getResult());
        System.out.println(lottoGame.getProfitRatio());
    }
}
