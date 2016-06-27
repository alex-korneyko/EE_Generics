import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Alex Korneyko on 27.06.2016.
 */
public class SimpleTask<T extends List<Integer>> implements Task<T> {

    private boolean isExecuted = false;
    T list;

    @Override
    public void execute() {
        isExecuted = true;
        IntStream.range(0, 10).forEach((i) -> list.add((int) (Math.random()) * 15));
    }

    @Override
    public T getResult() {
        return list;
    }

    public boolean isExecuted() {
        return isExecuted;
    }
}
