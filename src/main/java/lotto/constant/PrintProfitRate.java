package lotto.constant;

import org.assertj.core.util.TriFunction;

import java.util.Map;

public enum PrintProfitRate {
    RATE{
        @Override
        public String calc(Map<Integer, Integer>map) {
            return
                    "3개 일치 (5,000원) - "+map.get(3)+"개"+"\n"+
                    "4개 일치 (50,000원) - "+map.get(4)+"개"+"\n"+
                    "5개 일치 (1,500,000원) - "+map.get(5)+"개"+"\n"+
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - "+map.get(99)+"개"+"\n"+
                    "6개 일치 (2,000,000,000원) - "+map.get(6)+"개";
        }
    };

    public abstract  String calc(Map<Integer, Integer>map);
}
