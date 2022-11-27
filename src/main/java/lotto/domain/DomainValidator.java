package lotto.domain;

import lotto.domain.constant.LottoNumberProperties;

import java.util.List;

public class DomainValidator {
    public static boolean isIncorrectSize(List<Integer> numbers) {
        return numbers.size() != LottoNumberProperties.SIZE.get();

    }

    public static boolean hasInvalidRangeNumber(List<Integer> numbers) {
        return numbers.stream().anyMatch(DomainValidator::isInvalidRange);
    }

    public static boolean isInvalidRange(int number) {
        return number < LottoNumberProperties.MIN_NUMBER.get()
                || number > LottoNumberProperties.MAX_NUMBER.get();
    }

    public static boolean hasSameNumber(List<Integer> numbers, int correctSize) {
        return numbers.stream().distinct().count() != correctSize;
    }
}
