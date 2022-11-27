package lotto.enums;

import java.text.DecimalFormat;
import java.util.Arrays;

public enum LottoWinningInfo {
    FIRST(1, 6, false, 2_000_000_000),
    SECOND(2, 5, true, 30_000_000),
    THIRD(3, 5, false, 1_500_000),
    FOURTH(4, 4, false, 50_000),
    FIFTH(5, 3, false, 5_000),
    ;

    private final int ranking;
    private final int originNumberMatchCount;
    private final boolean bonusNumberMatch;
    private final int prize;

    LottoWinningInfo(int ranking, int originNumberMatchCount, boolean bonusNumberMatch, int prize) {
        this.ranking = ranking;
        this.originNumberMatchCount = originNumberMatchCount;
        this.bonusNumberMatch = bonusNumberMatch;
        this.prize = prize;
    }

    public static boolean containsOriginNumberMatchCount(int count) {
        return Arrays.stream(LottoWinningInfo.values()).anyMatch(v -> v.originNumberMatchCount == count);
    }
    public static LottoWinningInfo find(int originNumberMatchCount, boolean bonusNumberMatch) {
        return Arrays.stream(LottoWinningInfo.values()).filter(v -> v.originNumberMatchCount==originNumberMatchCount && v.bonusNumberMatch==bonusNumberMatch).findFirst().orElseThrow();
    }
    public static LottoWinningInfo getRank(int originNumberMatchCount) {
        return find(originNumberMatchCount, false);
    }
    public static LottoWinningInfo getRank(int originNumberMatchCount, boolean bonusNumberMatch) {
        return find(originNumberMatchCount, bonusNumberMatch);
    }
    public int getPrize() {
        return prize;
    }
    public String getFormattedPrize() {
        DecimalFormat formatter = new DecimalFormat("###,###");
        return formatter.format(prize);
    }

    public int getOriginNumberMatchCount() {
        return originNumberMatchCount;
    }

    public int getRanking() {
        return ranking;
    }

    public boolean isSecond() {
        return this == SECOND;
    }

}
