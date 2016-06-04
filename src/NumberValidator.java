/**
 * Created by Alex Korneyko on 04.06.2016.
 */
public class NumberValidator implements Validator<Number> {
    @Override
    public boolean isValid(Number result) {

        return result.longValue() % 2 == 0;
    }
}
