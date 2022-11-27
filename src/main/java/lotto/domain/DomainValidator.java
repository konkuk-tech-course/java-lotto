package lotto.domain;

import lotto.domain.constant.LottoProperties;

import java.util.List;

public class DomainValidator {
    public static boolean isIncorrectSize(List<Integer> numbers) {
        return numbers.size() != LottoProperties.SIZE.get();

    }

    public static boolean hasInvalidRangeNumber(List<Integer> numbers) {
        return numbers.stream().anyMatch(DomainValidator::isInvalidRange);
    }

    private static boolean isInvalidRange(int number) {
        return number < LottoProperties.MIN_NUMBER.get()
                && number > LottoProperties.MAX_NUMBER.get();
    }

    public static boolean hasSameNumber(List<Integer> numbers) {
        return numbers.stream().distinct().count() != LottoProperties.SIZE.get();
    }
}
