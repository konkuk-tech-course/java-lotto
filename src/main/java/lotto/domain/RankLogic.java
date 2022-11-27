package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.rank.Ranking;

public class RankLogic {

    public static Map<Ranking, Integer> rankMap= new HashMap<Ranking,Integer>();

    public void logicStart(List<Lotto> lottoList, List<Integer> winningNumber, int bonus){
        setMap();
        matchCount(lottoList,winningNumber,bonus);
    }

    public void matchCount(List<Lotto> lottoList, List<Integer> winningNumber, int bonus) {
        for(int i=0; i< lottoList.size(); i++){
            long count = lottoList.get(i).getNumbers().stream()
                .filter(auttoLotto -> winningNumber.contains(auttoLotto)).count();
            if(count==5){
                count=hasBonus(lottoList,i, bonus);
            }
            updateRanking(count);
        }
    }

    private static void updateRanking(long count) {
        Ranking ranking = Ranking.countRank(count);
        rankMap.put(ranking, rankMap.get(ranking)+1);
    }

    private int hasBonus(List<Lotto> lottoList, int index, int bonus){
        if(lottoList.get(index).getNumbers().stream().anyMatch(num -> num==bonus)){
            return 7;
        }
        return 5;
    }


    private void setMap(){
        rankMap.put(Ranking.RANK_NONE, 0);
        rankMap.put(Ranking.RANK_5,0);
        rankMap.put(Ranking.RANK_4,0);
        rankMap.put(Ranking.RANK_3,0);
        rankMap.put(Ranking.RANK_2,0);
        rankMap.put(Ranking.RANK_1,0);
    }


}

