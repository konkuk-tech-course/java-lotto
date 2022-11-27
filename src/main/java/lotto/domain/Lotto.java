package lotto.domain;


import lotto.constant.ExceptionPhrase;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        rangeValidate(numbers);
        duplicateValidation(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionPhrase.숫자6개아니면안됨.getMessage());
        }
    }

    private void rangeValidate(List<Integer> numbers) {
        for (Integer number : numbers) {
            if(number < 1 || number > 45) {
                throw new IllegalArgumentException(ExceptionPhrase.범위외금지.getMessage());
            }
        }
    }

    private void duplicateValidation(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if(set.size() != 6) {
            throw new IllegalArgumentException(ExceptionPhrase.중복된숫자있으면안됩니다.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
