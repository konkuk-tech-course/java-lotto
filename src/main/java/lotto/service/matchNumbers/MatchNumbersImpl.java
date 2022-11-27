package lotto.service.matchNumbers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchNumbersImpl implements MatchNumbers{

    public Map<Integer, Integer> calculateRank(List<List<Integer>> publishedNumbers, List<Integer> lotto, int bonus) {
        Map<Integer, Integer> map = new HashMap<>();
        inputMap(map);
        for(List<Integer> list : publishedNumbers) {
            int count = calculateCount(list, lotto);
            count = bonusMatch(count, list, bonus);
            saveMatches(map, count);
        }
        return map;
    }

    private void inputMap(Map<Integer, Integer> map) {
        map.put(3,0);
        map.put(4,0);
        map.put(5,0);
        map.put(99,0);
        map.put(6,0);
    }

    private int calculateCount(List<Integer> list, List<Integer> lotto) {
        int count = 0;
        for(int number : list) {
            if(lotto.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private int bonusMatch(int count, List<Integer> list, int bonus) {
        if(count == 5) {
            if(list.contains(bonus)) {
                count = 99;
            }
        }
        return count;
    }

    private void saveMatches(Map<Integer, Integer> map, int count) {
        if(map.containsKey(count)) {
            int value = map.get(count);
            value++;
            map.put(count, value);
        }
        if(!map.containsKey(count)) {
            map.put(count, 1);
        }
    }
}
