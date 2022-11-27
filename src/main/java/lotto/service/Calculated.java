package lotto.service;

import java.util.Map;
import lotto.rank.Ranking;
import lotto.view.OutputView;

public class Calculated {

    private final int THOUSAND=1000;
    OutputView outputView = new OutputView();

    static double yield=0;
    public int lottoAmount(int userMoney){
        outputView.printAmount(userMoney/THOUSAND);
        return userMoney/THOUSAND;
    }

    public double calculateYield(int userMoney, Map<Ranking, Integer> rankMap){
        int sum=0;
        for(Ranking ranking: rankMap.keySet()){
            sum += ranking.getRankMoney()*rankMap.get(ranking);
        }
        yield = (double)sum/userMoney * 100;
        return yield;
    }

}
