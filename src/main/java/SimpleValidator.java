import java.util.ArrayList;
import java.util.List;

public class SimpleValidator<T extends List<Integer>> implements Validator<T> {
    @Override
    public boolean isValid(T result, Class<? extends List> classObject) throws IllegalAccessException, InstantiationException {

        T tempListForValidate = (T) classObject.newInstance();
        result.forEach(tempListForValidate::add);

        sort(tempListForValidate);

        return progressionIsCorrect(tempListForValidate);

    }

    private boolean progressionIsCorrect(T tempListForValidate) {
        for (int i = 1; i < tempListForValidate.size(); i++) {
            if (tempListForValidate.get(i) - tempListForValidate.get(i - 1) != 1) {
                return false;
            }
        }
        return true;
    }

    private void sort(T tempListForValidate) {

        boolean listChanged = true;

        while (listChanged) {
            listChanged = false;
            for (int i = 1; i < tempListForValidate.size(); i++) {
                if (tempListForValidate.get(i - 1).compareTo(tempListForValidate.get(i)) > 0) {
                    swapElementsBack(tempListForValidate, i);
                    listChanged = true;
                }
            }
        }
    }

    private void swapElementsBack(T listForElementSwap, int i) {
        int temp = listForElementSwap.get(i - 1);
        listForElementSwap.set(i - 1, listForElementSwap.get(i));
        listForElementSwap.set(i, temp);
    }
}
