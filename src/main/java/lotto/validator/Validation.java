package lotto.validator;

import lotto.constant.ExceptionPhrase;

import java.util.NoSuchElementException;

public class Validation {
    //숫자 확인, 범위 확인(?)
    public void parseValidation(String number) {
        try{
            Integer.parseInt(number);
        } catch (NumberFormatException | NoSuchElementException e) {
            throw new IllegalArgumentException(ExceptionPhrase.문자금지.getMessage());
        }
    }


}
