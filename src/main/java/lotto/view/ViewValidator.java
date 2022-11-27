package lotto.view;

import lotto.view.constant.ValidationRegex;
import lotto.view.constant.ViewErrorMessage;

import java.util.List;
import java.util.regex.Pattern;

public class ViewValidator {
    public static void validateNumberInput(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException(ViewErrorMessage.EMPTY.get());
        }

        if (hasNonNumericValue(input)) {
            throw new IllegalArgumentException(ViewErrorMessage.NOT_NUMBER.get());
        }
    }

    public static void validateWinningNumberInput(List<String> numbers) {
        if (hasEmptyValue(numbers)) {
            throw new IllegalArgumentException(ViewErrorMessage.EMPTY.get());
        }

        if (containsNonNumericValue(numbers)) {
            throw new IllegalArgumentException(ViewErrorMessage.NOT_NUMBER.get());
        }
    }

    private static boolean hasEmptyValue(List<String> numbers) {
        return numbers.stream().anyMatch(ViewValidator::isEmpty);
    }

    private static boolean containsNonNumericValue(List<String> numbers) {
        return numbers.stream().anyMatch(ViewValidator::hasNonNumericValue);
    }

    private static boolean isEmpty(String input) {
        return Pattern.matches(ValidationRegex.EMPTY.get(), input);
    }

    private static boolean hasNonNumericValue(String input) {
        return !Pattern.matches(ValidationRegex.NUMBER.get(), input);
    }
}
