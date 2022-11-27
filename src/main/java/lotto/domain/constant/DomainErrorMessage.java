package lotto.domain.constant;

public enum DomainErrorMessage {
    INVALID_SIZE("로또 숫자는 6개의 숫자여야 합니다."),
    INVALID_RANGE(LottoProperties.MIN_NUMBER.get() + "부터 " + LottoProperties.MAX_NUMBER.get()
            + "까지의 숫자만 허용됩니다."),
    DUPLICATED_NUMBERS("중복된 숫자가 없도록 입력해주세요");

    private static final String prefix = "[ERROR] ";
    private final String message;

    DomainErrorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return prefix + message;
    }
}

