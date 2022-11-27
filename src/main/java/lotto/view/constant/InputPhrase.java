package lotto.view.constant;

public enum InputPhrase {
    MONEY_INPUT("구입금액을 입력해 주세요.");

    private final String phrase;

    private InputPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String get() {
        return phrase;
    }
}
