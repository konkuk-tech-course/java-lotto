package lotto.service.profitRate;

import java.util.Map;

public interface ProfitRate {

    public int calculateTotalProfit(Map<Integer, Integer> map);

    public double calculateProfitRate(int profit, int money);

}
