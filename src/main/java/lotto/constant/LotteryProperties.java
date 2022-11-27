package lotto.constant;

public enum LotteryProperties {
    PRICE(1000),
    MIN_MATCH_FOR_REWARD(3);

    private final int property;

    LotteryProperties(int property) {
        this.property = property;
    }

    public int get() {
        return property;
    }
}
