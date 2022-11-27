package lotto;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lotto {
    private final List<Integer> numbers;
    Pattern pattern = Pattern.compile("^[0-9]+$");
    public Lotto(List<Integer> numbers) { // 당첨 번호에 대해서 검증? 아니면 오는 로또들에 대해서 검증?
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicated(numbers);
        validateInRange(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 갯수는 6개여야 합니다.");
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        if (numbers.stream().distinct().count()!= numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에서는 중복된 숫자가 올 수 없습니다.");
        }
    }

    private void validateInRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(num -> 1 > num || 45 < num)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에서의 숫자 범위는 1-45사이입니다.");
        }
    }

    private void validateNoString(String number){
        Matcher matcher = pattern.matcher(number);
        if(!matcher.find()){
            throw new IllegalArgumentException("[ERROR] 로또 번호에서는 숫자만 올 수 있습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
// TODO: 추가 기능 구현
}
