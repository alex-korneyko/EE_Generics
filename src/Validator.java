/**
 * Created by Alex Korneyko on 03.06.2016.
 */
public interface Validator<T> {

    // Валидирует переданое значение
    boolean isValid(T result);
}
