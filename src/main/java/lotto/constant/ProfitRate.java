package lotto.constant;

import java.util.function.Function;

public enum ProfitRate {
    RATE(x -> String.valueOf(x));

    private final Function<Double,String> expression;

    ProfitRate(Function<Double, String> expression) {
        this.expression = expression;
    }

    public String print(double x) {
        return "총 수익률은 " + x+"%입니다.";
    }


}
