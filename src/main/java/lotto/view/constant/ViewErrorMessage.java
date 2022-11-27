package lotto.view.constant;

public enum ViewErrorMessage {
    EMPTY("빈 값을 입력했습니다. 값을 입력해주세요"),
    NOT_NUMBER("숫자만 입력해주세요.");

    private static final String prefix = "[ERROR] ";
    private final String message;

    private ViewErrorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return prefix + message;
    }
}
