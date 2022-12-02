package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.service.Lotto;
import lotto.view.OutputView;

public class AutoLotto {

    public static List<Lotto> autoLottos = new ArrayList<>();
    public List<Lotto> pickAutoLotto(int lottoAmount, OutputView outputView){
        for(int index=0; index<lottoAmount; index++){
            List<Integer> pickLotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(pickLotto);
            Lotto lotto = new Lotto(pickLotto);
            autoLottos.add(lotto);
            outputView.printAutoLotto(pickLotto);
        }
        return autoLottos;
    }


}
