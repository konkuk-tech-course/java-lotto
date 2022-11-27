package lotto.service.matchNumbers;

import java.util.List;
import java.util.Map;

public interface MatchNumbers {
    Map<Integer, Integer> calculateRank(List<List<Integer>> publishedNumbers, List<Integer> lotto, int bonus);

}
