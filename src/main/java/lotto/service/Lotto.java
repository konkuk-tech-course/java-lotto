package lotto.service;

import java.util.List;
import lotto.constant.GameException;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicated(numbers);
        validateInRange(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(GameException.ERROR_LOTTO_SIZE.message());
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        if (numbers.stream().distinct().count()!= numbers.size()) {
            throw new IllegalArgumentException(GameException.ERROR_LOTTO_DUPLICATE.message());
        }
    }

    private void validateInRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(num -> 1 > num || 45 < num)) {
            throw new IllegalArgumentException(GameException.ERROR_LOTTO_RANGE.message());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
