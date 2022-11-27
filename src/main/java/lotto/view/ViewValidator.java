package lotto.view;

import lotto.view.constant.ValidationRegex;
import lotto.view.constant.ViewErrorMessage;

import java.util.regex.Pattern;

public class ViewValidator {
    public static void validateNumberInput(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException(ViewErrorMessage.EMPTY.get());
        }

        if (isNumber(input)) {
            throw new IllegalArgumentException(ViewErrorMessage.NOT_NUMBER.get());
        }
    }

    private static boolean isEmpty(String input) {
        return Pattern.matches(ValidationRegex.EMPTY.get(), input);
    }

    private static boolean isNumber(String input) {
        return Pattern.matches(ValidationRegex.NUMBER.get(), input);
    }
}
