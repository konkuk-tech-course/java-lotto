package view;

import domain.LottoGenerator;
import domain.WinningNumber;
import lotto.Lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputResultGenerator {

    private final WinningNumber winningNumber;
    private final LottoGenerator lottoGenerator;

    private final Map<Integer, Integer> matchedLotteryNum = new HashMap<>();

    private String result;
    private int totalWonMoney;

    public OutputResultGenerator(WinningNumber winningNumber, LottoGenerator lottoGenerator) {
        this.winningNumber = winningNumber;
        this.lottoGenerator = lottoGenerator;
    }

    // 당첨 번호와 생성한 로또 일치내역을 비교해야함.
    // 보너스 넘버, 당첨 번호와 lotto 리스트가 필요함

    // Lottogenerator의 로또와 winningNumber를 비교해서 일치하는 로직 생성 (로또 객체끼리 비교)
    // 위 matchedLotteryNum에 3,4,5,6 각각 개수를 저장함.
    public void calculateWinningResultToMap() {
        Lotto winningNumbers = winningNumber.getWinningNumbers();
        List<Lotto> generatedLottos = lottoGenerator.getGeneratedLottos();

        generatedLottos.stream()
                .map(lotto -> lotto.matchCount(winningNumbers))
                .filter(i -> i >= 3)
                .forEach(i -> matchedLotteryNum.put(i, matchedLotteryNum.getOrDefault(i, 0) + 1));
    }



    public String makeResult() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.toString();
    }

    public String getResult() {
        return result;
    }
}
