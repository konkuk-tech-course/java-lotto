package lotto.enums;

public enum LottoTicketRule {
    LOWER_NUMBER(1, "로또의 가장 작은 수"),
    UPPER_NUMBER(45, "로또의 가장 큰 수 "),
    NUMBERS_COUNT(6, "로또 한장의 총 숫자 개수"),
    ;

    private String guide;
    private int rule;

    LottoTicketRule(int rule, String guide) {
        this.rule = rule;
        this.guide = guide;
    }


    public int getRule() {
        return rule;
    }

}
