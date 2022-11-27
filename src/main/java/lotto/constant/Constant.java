package lotto.constant;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public enum Constant {

    세개_일치(3, 5000),
    네개_일치(4, 50_000),
    다섯개_일치(5, 1_500_000),
    다섯개_일치_보너스_볼_일치(99, 30_000_000),
    여섯개_일치(6,2_000_000_000),
    그외(-1, 0);

    private final int count;
    private final int rewards;

    Constant(int count, int rewards) {
        this.count = count;
        this.rewards = rewards;
    }

    public static int returnRewards(int count) {
        return   Arrays.stream(Constant.values())
                .filter(o -> o.count == count)
                .map(o -> o.rewards)
                .findAny()
                .orElse(0);
    }
}
