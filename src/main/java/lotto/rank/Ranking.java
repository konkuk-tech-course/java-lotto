package lotto.rank;

import java.util.Arrays;

public enum Ranking {
    RANK_NONE(0,0,0),
    RANK_5(3, 5000, 0),
    RANK_4(4,50000, 0),
    RANK_3(5, 1500000, 0),
    RANK_2(7,30000000, 0),
    RANK_1(6,2000000000,0);


    Ranking(int same, int rankMoney, int rankCount) {
        this.same=same;
        this.rankMoney=rankMoney;
        this.rankCount=rankCount;
    }

    public Ranking findRank(int count){
        for(Ranking ranking : Ranking.values()){
            if(count==ranking.same){
                return ranking;
            }
        }
        return RANK_NONE;
    }

    private int same;
    private int rankCount;
    private int rankMoney;


    public int getSame() {
        return same;
    }

    public int getRankCount() {
        return rankCount;
    }

    public String getRankMoney() {
        return rankMoney;
    }
}
