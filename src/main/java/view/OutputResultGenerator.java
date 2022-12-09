package view;

import domain.LottoGenerator;
import domain.Rank;
import domain.WinningNumber;
import lotto.Lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

// 결과를 생성하는 클래스.
// 결과 생성하려면 필요한 것 : 1. 당첨 횟수 -> 2. enum 활용해 전체 수익 계산 3.수익률 계산, 4. 종합해서 최종결과 string으로 만들어 주는 메서드

public class OutputResultGenerator {

    private final WinningNumber winningNumber;
    private final LottoGenerator lottoGenerator;

    private final Map<Rank, Integer> matchedLotteryNum = new HashMap<>();

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
    // 보너스볼이랑 일치 여부 비교 해야함.
    public void calculateWinningResultToMap() {
        Lotto winningNumbers = winningNumber.getWinningNumbers();
        List<Lotto> generatedLottos = lottoGenerator.getGeneratedLottos();
        int bonusNumber = winningNumber.getBonusNumber();
        calculateSecondWinner(winningNumbers, generatedLottos, bonusNumber);
        calculateThirdWinner(winningNumbers, generatedLottos, bonusNumber);

        generatedLottos.stream()
                .map(lotto -> lotto.matchCount(winningNumbers))
                .filter(i -> (i >= 3 && i != 5))
                .forEach(i -> matchedLotteryNum.put(Rank.findByMatchCount(i), matchedLotteryNum.getOrDefault(Rank.findByMatchCount(i), 0) + 1));
    }

    private void calculateThirdWinner(Lotto winningNumbers, List<Lotto> generatedLottos, int bonusNumber) {
        int thirdWinnerCount = (int) generatedLottos
                .stream().filter(lotto -> lotto.matchCount(winningNumbers) == 5)
                .filter(lotto -> !lotto.contains(bonusNumber))
                .count();
        matchedLotteryNum.put(Rank.THIRD, thirdWinnerCount);
    }

    private void calculateSecondWinner(Lotto winningNumbers, List<Lotto> generatedLottos, int bonusNumber) {
        int secondWinnerCount = (int) generatedLottos.stream()
                .filter(lotto -> lotto.matchCount(winningNumbers) == 5) // 5개 일치하는거 골라서
                .filter(lotto -> lotto.contains(bonusNumber))   // bonus number 포함하는지 확인하고
                .count();
        matchedLotteryNum.put(Rank.SECOND, secondWinnerCount);
    }

    public void calculateWinningMoney() {
        for (Map.Entry<Rank, Integer> rankIntegerEntry : matchedLotteryNum.entrySet()) {
            totalWonMoney += rankIntegerEntry.getKey().getWinningMoney() * rankIntegerEntry.getValue();
        }
    }

    public String makeResult() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.toString();
    }

    public String getResult() {
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(Rank.SECOND == Rank.SECOND);

    }
}
