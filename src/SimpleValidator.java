import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex Korneyko on 27.06.2016.
 */
public class SimpleValidator<T extends List<Integer>> implements Validator<T> {
    @Override
    public boolean isValid(T result) {

        T tempListForValidate = (T) new ArrayList<Integer>();
        result.forEach(tempListForValidate::add);

        sort(tempListForValidate);

        return !progressionIsCorrect(tempListForValidate);

    }

    private boolean progressionIsCorrect(T tempListForValidate) {
        for (int i = 1; i < tempListForValidate.size(); i++) {
            if (tempListForValidate.get(i) - tempListForValidate.get(i - 1) != 1) {
                return true;
            }
        }
        return false;
    }

    private void sort(T tempListForValidate) {
        for (int i = 1; i < tempListForValidate.size(); i++) {
            if (tempListForValidate.get(i - 1).compareTo(tempListForValidate.get(i)) > 0) {
                swapElementsBack(tempListForValidate, i);
            }
        }
    }

    private void swapElementsBack(T result, int i) {
        int temp = result.get(i - 1);
        result.set(i - 1, result.get(i));
        result.set(i, temp);
    }
}
