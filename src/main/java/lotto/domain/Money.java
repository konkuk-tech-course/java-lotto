package lotto.domain;

public class Money {


    public static final int THOUSAND_WON = 1000;
    private static final int MAX_RANGE = 2_000_000_000;

    private final int money;
    public Money(int money) {
        this.money = money;
    }

    public int count(int money) {
        validate(money);
        return money / THOUSAND_WON;
    }

    public void validate(int money) {
        if(money % THOUSAND_WON != 0 || !(money >= THOUSAND_WON && money <= MAX_RANGE)) {
            throw new IllegalArgumentException();
        }
    }

    public int getMoney() {
        return money;
    }
}
