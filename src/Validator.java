import java.util.List;

public interface Validator<T extends List<Integer>> {

    // Валидирует переданое значение
    boolean isValid(T result);
}
