package lotto.domain;

public class Calculated {

    private final int THOUSAND=1000;

    public int lottoAmount(int userMoney){
        return userMoney/THOUSAND;
    }

}
