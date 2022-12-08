package domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoGenerator {

    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;
    private static final int LOTTO_SIZE = 6;

    // 랜덤으로 개수만큼의
    private final int lottoCount;
    private final List<Lotto> generatedLottos;

    public List<Lotto> getGeneratedLottos() {
        return generatedLottos;
    }

    public LottoGenerator(int lottoCount) {
        this.lottoCount = lottoCount;
        generatedLottos = generateLotto();
    }
    public List<Lotto> generateLotto() {
        List<Lotto> generatedLottos = new ArrayList<>();
        addToLottoList(generatedLottos);
        return generatedLottos;
    }

    private void addToLottoList(List<Lotto> generatedLottos) {
        IntStream.rangeClosed(1, lottoCount)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUM, LOTTO_MAX_NUM, LOTTO_SIZE)))
                .forEach(generatedLottos::add);
    }

    public static void main(String[] args) {

        LottoGenerator lottoGenerator = new LottoGenerator(8);
        List<Lotto> generatedLottos1 = lottoGenerator.getGeneratedLottos();
        generatedLottos1.forEach(System.out::println);
    }
}
