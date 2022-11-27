package lotto.domain;

import java.util.Map;
import lotto.rank.Ranking;

public class Calculated {

    private final int THOUSAND=1000;

    double yield=0;
    public int lottoAmount(int userMoney){
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
