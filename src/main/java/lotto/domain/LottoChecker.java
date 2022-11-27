package lotto.domain;

import lotto.enums.LottoWinningInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoChecker {
    private final Map<LottoWinningInfo, Integer> record;

    public LottoChecker() {
        this.record = initRecord();
    }

    private Map<LottoWinningInfo, Integer> initRecord() {
        Map<LottoWinningInfo, Integer> record = new HashMap<>();
        for (LottoWinningInfo rank :
                LottoWinningInfo.values()) {
            record.put(rank, 0);
        }
        return record;
    }

    public Map<LottoWinningInfo, Integer> judge(List<Lotto> lottos, FirstLotto firstLotto, int bonusNumber) {
        for (Lotto lotto :
                lottos) {
            List<Integer> firstNumbers = firstLotto.getNumbers();
            List<Integer> numbers = lotto.getNumbers();
            numbers.retainAll(firstNumbers);

            int matchedCount = numbers.size();
            if (LottoWinningInfo.containsOriginNumberMatchCount(matchedCount)) {
                LottoWinningInfo ranking;
                ranking = LottoWinningInfo.getRank(matchedCount);
                if (matchedCount == 5) {
                    ranking = LottoWinningInfo.getRank(matchedCount, checkBonusNumber(numbers, lotto, bonusNumber));
                }
                increaseRecordCount(ranking);
            }
        }
        return record;
    }

    private boolean checkBonusNumber(List<Integer> numbers, Lotto lotto, int bonusNumber) {
        List<Integer> origin = lotto.getNumbers();
        origin.removeAll(numbers);
        return origin.get(0) == bonusNumber;
    }

    private void increaseRecordCount(LottoWinningInfo ranking) {
        record.put(ranking, record.get(ranking) + 1);
    }
}
