package lotto.input;

public interface Input<T> {

    public String inputNumbers();

    public T parseInt(String numbers);
}
