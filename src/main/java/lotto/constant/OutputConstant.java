package lotto.constant;

public enum OutputConstant {

    INPUT_MONEY("구입 금액을 입력해주세요."),
    PRINT_AMOUNT("개를 구매했습니다."),
    INPUT_WINNING_LOTTO("당첨 번호를 입력해주세요."),
    INPUT_BONUS("보너스 번호를 입력해주세요."),
    GAME_STATISTIC_ANNONUNCE("\n당첨 통계\n---");

    private String string;

    OutputConstant(String string) {
        this.string = string;
    }

    public String message() {
        return string;
    }
}
