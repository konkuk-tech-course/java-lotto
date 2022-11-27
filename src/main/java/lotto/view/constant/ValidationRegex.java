package lotto.view.constant;

public enum ValidationRegex {
    EMPTY("^$"),
    NUMBER("^[0-9]+$");

    private final String regex;

    private ValidationRegex(String regex) {
        this.regex = regex;
    }

    public String get() {
        return regex;
    }
}
