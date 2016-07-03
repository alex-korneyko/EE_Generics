import java.util.List;
import java.util.stream.IntStream;


public class SimpleTask<T extends List<Integer>> implements Task<T> {

    private T list;
    private T initList;
    private boolean isExecuted = false;

    public SimpleTask(Class<? extends List> classObject) {
        try {
            list = (T) classObject.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public SimpleTask(Class<? extends List> classObject, T list) {
        this(classObject);
        this.initList = list;
    }

    @Override
    public void execute() {
        isExecuted = true;
        if(initList == null) {
            IntStream.range(0, 10).forEach((i) -> list.add((int) (Math.random() * 10)));
        } else {
            list = initList;
        }
    }

    @Override
    public T getResult() {
        return list;
    }

    public boolean isExecuted() {
        return isExecuted;
    }
}
