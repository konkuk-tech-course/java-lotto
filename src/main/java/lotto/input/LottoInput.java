package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.Validation;

import java.util.ArrayList;
import java.util.List;

public class LottoInput implements Input<List<Integer>>{

    private final Validation lottoValidation;

    public LottoInput() {
        this.lottoValidation = new Validation();
    }

    @Override
    public String inputNumbers() {
        return Console.readLine();
    }

    @Override
    public List<Integer> parseInt(String numbers) {
        String[] input = numbers.split(",");
        List<Integer> number = new ArrayList<>();
        for (String s : input) {
            s = s.trim();
            lottoValidation.parseValidation(s);
            number.add(Integer.parseInt(s));
        }
        return number;
    }
}
