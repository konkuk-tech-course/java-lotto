package lotto.domain.constant;

public enum LottoProperties {
    SIZE(6),
    SIZE_WITH_BONUS_NUMBER(7),
    MIN_NUMBER(1),
    MAX_NUMBER(45);

    private final int property;

    LottoProperties(int property) {
        this.property = property;
    }

    public int get() {
        return property;
    }
}
