package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto{
    private static final String DELIMITER = ", ";
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sortNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또의 크기가 6이 아닙니다.");
        }
    }

    // TODO: 추가 기능 구현
    // lotto에서 sort하는 기능
    private void sortNumber(List<Integer> numbers) {
        Collections.sort(numbers, Comparator.naturalOrder());
    }

    public int matchCount(Lotto lotto) {
        List<Integer> commonNumber = new ArrayList<>(numbers);
        numbers.retainAll(lotto.numbers);
        return commonNumber.size();
    }
    @Override
    public String toString() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER, PREFIX, SUFFIX));
    }

    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
