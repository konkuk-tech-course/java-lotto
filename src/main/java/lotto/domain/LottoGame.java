package lotto.domain;

import lotto.enums.LottoWinningInfo;

import java.util.List;
import java.util.Map;

public class LottoGame {
    private final List<Lotto> lottos;
    private final FirstLotto firstLotto;
    private final int bonusNumber;
    private Map<LottoWinningInfo, Integer> result;
    public LottoGame(List<Lotto> lottos, FirstLotto firstLotto, int bonusNumber) {
        this.lottos = lottos;
        this.firstLotto = firstLotto;
        this.bonusNumber = bonusNumber;
    }

    public void analyzeWinningResult() {
        LottoChecker lottoChecker = new LottoChecker();
        result = lottoChecker.judge(lottos, firstLotto, bonusNumber);
    }

    public Map<LottoWinningInfo, Integer> getResult() {
        return result;
    }

    public float getProfitRatio() {
        int totalWinningPrize = 0;
        for( LottoWinningInfo ranking : result.keySet() ){
            int winningCount = result.get(ranking);
            int winningByRanking = ranking.getPrize() * winningCount;
            totalWinningPrize += winningByRanking;
        }
        int inputMoney = LottoBuyingMoney.convertInputMoney(lottos.size());
        return (float) (( totalWinningPrize / (double) inputMoney ) * 100);
    }
}
