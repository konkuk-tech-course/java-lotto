package lotto.domain;

import lotto.constant.LotteryProperties;
import lotto.domain.constant.LottoNumberProperties;

import java.util.List;

public class DomainValidator {
    private static final int EMPTY = 0;

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

    public static boolean isMoneyZero(int money) {
        return money == EMPTY;
    }

    public static boolean isMultiplyOfCorrectUnit(int money) {
        return money % LotteryProperties.PRICE.get() == EMPTY;
    }
}
