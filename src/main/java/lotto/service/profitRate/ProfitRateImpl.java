package lotto.service.profitRate;

import lotto.constant.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProfitRateImpl implements ProfitRate{
    @Override
    public int calculateTotalProfit(Map<Integer, Integer> map) {
        List<Integer> list = new ArrayList<>(map.keySet());

        int sum = 0;
        for (Integer m : list) {
            int money = Constant.returnRewards(m);
            sum += money * map.get(m);
        }
        return sum;
    }

    @Override
    public double calculateProfitRate(int profit, int money) {
        return Math.round(((double) profit / (double) money) * 1000)/10.0;
    }

}
