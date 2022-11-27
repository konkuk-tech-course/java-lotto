package lotto.rank;

import java.util.Arrays;

public enum Ranking {
    RANK_NONE(0,0),
    RANK_5(3, 5000),
    RANK_4(4,50000),
    RANK_3(5, 1500000),
    RANK_2(7,30000000),
    RANK_1(6,2000000000);


    Ranking(int same, int rankMoney) {
        this.same =same;
        this.rankMoney=rankMoney;
    }

    public static Ranking countRank(long count){
        for(Ranking ranking : Ranking.values()){
            if(count==ranking.same){
              return ranking;
            }
        }
        return RANK_NONE;
    }



    private int same;
    private int rankMoney;


    public int getSame() {
        return same;
    }


    public int getRankMoney() {
        return rankMoney;
    }
}
