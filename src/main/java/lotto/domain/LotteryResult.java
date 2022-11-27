package lotto.domain;

import lotto.constant.LotteryProperties;
import lotto.constant.LotteryRank;
import lotto.constant.Status;
import org.assertj.core.groups.Tuple;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LotteryResult {
    private static final int INCREASE_UNIT = 1;
    private static final int TOTAL_PERCENTAGE = 100;

    private String userId;
    private Map<LotteryRank, Integer> results;

    public LotteryResult(String userId) {
        this.userId = userId;
        results = new HashMap<>();
        initResults();
    }

    private void initResults() {
        Arrays.stream(LotteryRank.values())
                .forEach(rank -> results.put(rank, Status.EMPTY.get()));
    }

    public void add(LotteryRank rank) {
        results.put(rank, results.get(rank) + INCREASE_UNIT);
    }

    public double calculateProfitRate() {
        return (double) calculateTotalReward()
                / calculatePurchaseMoney()
                * TOTAL_PERCENTAGE;
    }

    private long calculateTotalReward() {
        return results.keySet().stream()
                .mapToLong(rank -> calculateRankReward(rank, results.get(rank)))
                .sum();
    }

    private long calculateRankReward(LotteryRank rank, int count) {
        return (long) rank.getReward() * count;
    }

    private long calculatePurchaseMoney() {
        return (long) calculateCountOfResults() * LotteryProperties.PRICE.get();
    }

    private int calculateCountOfResults() {
        return results.values().stream()
                .mapToInt(count -> count)
                .sum();
    }

    public Map<LotteryRank, Integer> getResults() {
        return Collections.unmodifiableMap(results);
    }
}
