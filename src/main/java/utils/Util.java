package utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util {

    public static final String delimiter = ",";
    public static int convertStringToInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값을 입력하셨습니다.");
        }
    }

    public static List<Integer> convertStringToList(String winningNumbers) {
        try {
            return Arrays.stream(winningNumbers.split(delimiter))
                    .map(Util::convertStringToInt)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 값 또는 형식을 입력하셨습니다");
        }
    }

    public static void main(String[] args) {

        List<Integer> integers = Util.convertStringToList("1.2.3.4.5.6");
        System.out.println(integers);
    }
}
