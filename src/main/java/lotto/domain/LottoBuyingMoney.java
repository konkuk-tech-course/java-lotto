package lotto.domain;

public class LottoBuyingMoney {
    private final int money;

    public LottoBuyingMoney(int number) {
        validate(number);
        this.money = number;
    }

    private void validate(int number) {
        // 4자리이상의 정수
        // 뒤 세자리가 000이여야함
        // int 범위로 한정해서 받기
    }

    public int convertBuyingCount() {
        return money / 1000;
    }

    public static int convertInputMoney(int countOfLottos) {
        return countOfLottos * 1000;

    }
}
