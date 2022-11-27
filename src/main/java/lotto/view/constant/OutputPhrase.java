package lotto.view.constant;

public enum OutputPhrase {
    PURCHASE_COUNT("%d개를 구매했습니다.");

    private final String phrase;

    private OutputPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String get() {
        return phrase;
    }
}
