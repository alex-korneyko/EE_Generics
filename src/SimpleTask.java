import java.util.List;
import java.util.stream.IntStream;


public class SimpleTask<T extends List<Integer>> implements Task<T> {

    private T list;

    public SimpleTask(Class<? extends List<Integer>> classObject) {
        try {
            list = (T) classObject.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private boolean isExecuted = false;

    @Override
    public void execute() {
        isExecuted = true;
        IntStream.range(0, 10).forEach((i) -> list.add((int) (Math.random() * 10)));

    }

    @Override
    public T getResult() {
        return list;
    }

    public boolean isExecuted() {
        return isExecuted;
    }

    class listCreator {

    }
}
