package lotto.domain;

import lotto.constant.LotteryRank;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LotteryResult {
    private String userId;
    private Map<LotteryRank, Integer> results;

    public LotteryResult(String userId) {
        this.userId = userId;
        results = new HashMap<>();
    }

    public Map<LotteryRank, Integer> getResults() {
        return Collections.unmodifiableMap(results);
    }
}
