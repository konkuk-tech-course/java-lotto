package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Lotto;

public class WinningLotto {

    Validate validate = new Validate();


    List<Integer> winningLottos = new ArrayList<>();

    public List<Integer> settingWinningLottos(String winningLotto) {
        List<String> strings = Arrays.asList(winningLotto.split(","));
        for(int i=0; i<strings.size(); i++){
            int rightNumber = validate.validateNumber(strings.get(i));
            winningLottos.add(rightNumber);
        }
        Lotto lotto = new Lotto(winningLottos);
        return winningLottos;
    }
    public List<Integer> getWinningLottos() {
        return winningLottos;
    }


}
