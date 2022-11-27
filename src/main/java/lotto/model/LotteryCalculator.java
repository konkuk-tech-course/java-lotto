package lotto.model;// @ author ninaaano

import static lotto.model.constant.CommonCostants.MIN_LOTTO_PRICE;

/**
 * 입력받은 금액을 계산하는 클래스
 */
public class LotteryCalculator {
    private final int purchaseMoney;

    public LotteryCalculator(int money) {
        this.purchaseMoney = money;
    }


    public static int calculator(int money){
        return money / MIN_LOTTO_PRICE;
    }

}
