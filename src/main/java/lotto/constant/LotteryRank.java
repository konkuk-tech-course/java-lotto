package lotto.constant;

public enum LotteryRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    LOSE_WITH_TWO_MATCHES(2, 0),
    LOSE_WITH_ONE_MATCH(1, 0),
    LOSE_WITH_NO_MATCH(0, 0);

    private final int numberOfMatches;
    private final int reward;

    LotteryRank(int numberOfMatches, int reward) {
        this.numberOfMatches = numberOfMatches;
        this.reward = reward;
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public int getReward() {
        return reward;
    }
}
