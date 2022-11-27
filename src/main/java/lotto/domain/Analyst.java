package lotto.domain;

import lotto.enums.LottoWinningInfo;

import java.util.Map;

public class Analyst {
    private final StringBuilder report;
    private final LottoGame lottoGame;

    public Analyst(LottoGame lottoGame) {
        this.report = new StringBuilder();
        this.lottoGame = lottoGame;
    }

    private void makeReport() {
        writeWinningResult();
        writeProfitRatio();
    }

    private void writeProfitRatio() {
        Map<LottoWinningInfo, Integer> result = lottoGame.getResult();

        for (LottoWinningInfo ranking:
        result.keySet()) {
            String line = ranking.getOriginNumberMatchCount() + "개 일치 " + "(" + ranking.getFormattedPrize() + "원) - " + result.get(ranking) + "개\n";
            if (ranking.isSecond()) {
                line = ranking.getOriginNumberMatchCount() + "개 일치, 보너스 볼 일치 " + "(" + ranking.getFormattedPrize() + "원) - " + result.get(ranking) + "개\n";
            }
            report.append(line);
        }
    }
    private void writeWinningResult() {
        float ratio = lottoGame.getProfitRatio();
        System.out.println();
        System.out.println( ratio );
        System.out.println();
        String line = "총 수익률은 " + String.format("%.1f", ratio) + "%입니다.\n";
        report.append(line);
    }

    public String getReport() {
        makeReport();
        return report.toString();
    }
}
