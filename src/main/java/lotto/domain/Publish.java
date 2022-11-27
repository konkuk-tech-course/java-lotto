package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Publish {
    private final int count;

    public Publish(int count) {
        this.count = count;
    }

    public List<List<Integer>> publishNumbers(int count) {
        List<List<Integer>> publishNumbers = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            List<Integer> list = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            publishNumbers.add(list);
        }
        return publishNumbers;

    }

    public int getCount() {
        return count;
    }
}
