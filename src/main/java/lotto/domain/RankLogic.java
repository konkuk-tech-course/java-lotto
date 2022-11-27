package lotto.domain;

import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.rank.Ranking;

public class RankLogic {
    Map<Ranking, Integer> rankMap;
    public int matchCount(List<Lotto> lottoList, List<Integer> winningNumber, int bonus) {
        for(int i=0; i<lottoList.size(); i++){
            long count = lottoList.get(i).getNumbers().stream()
                .filter(auttoLotto -> winningNumber.contains(auttoLotto)).count();
            if(count==5){

            }
        }
    }

    public void int
}
