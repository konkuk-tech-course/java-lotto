package domain;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THRID(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    private final int winningCount;
    private final int winningMoney;

    Rank(int winningCount, int winningMoney) {
        this.winningCount = winningCount;
        this.winningMoney = winningMoney;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
