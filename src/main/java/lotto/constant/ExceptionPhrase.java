package lotto.constant;

public enum ExceptionPhrase {
    중복된숫자있으면안됩니다("중복 숫자 금지"),
    보너스숫자로또숫자와겹치면안됨니다("보너스 숫자 중복 숫자와 겹침 금지"),
    숫자6개아니면안됨("숫자 6개만 가능합니다."),
    범위외금지("1 - 45만 가능합니다."),
    문자금지("숫자 외 문자 금지");

    private final String message;

    ExceptionPhrase(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
