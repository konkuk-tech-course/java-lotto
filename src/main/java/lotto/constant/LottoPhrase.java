package lotto.constant;

public enum LottoPhrase {

    구입금액을_입력해_주세요("구입금액을 입력해 주세요."),
    개를_구매했습니다("개를 구매했습니다."),
    당첨_번호를_입력해주세요("당첨 번호를 입력해주세요."),
    보너스_번호를_입력해주세요("보너스 번호를 입력해 주세요."),
    당첨_통계("당첨 통계"),
    집가고_싶다("집가고 싶다");

    private final String phrase;

    LottoPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase() {
        return phrase;
    }
}
