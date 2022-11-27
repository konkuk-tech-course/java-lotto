package lotto.enums;

public enum Announcement {
    INPUT_MONEY_FOR_BUYING("구입금액을 입력해 주세요."),
    BUYING_COUNT_FORMAT("개를 구매했습니다."),
    INPUT_FIRST_LOTTO_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    ;
    private String message;

    Announcement(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
