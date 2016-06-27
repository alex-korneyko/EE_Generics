import java.util.List;

/**
 * Created by Alex Korneyko on 03.06.2016.
 */
public interface Validator<T extends List<Integer>> {

    // Валидирует переданое значение
    boolean isValid(T result);
}
