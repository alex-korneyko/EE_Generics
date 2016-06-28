import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

/**
 * Created by Alex Korneyko on 28.06.2016 12:27.
 */
public class MainExecutorTest {

    @Test
    public void addTaskWithoutValidator() {

        MainExecutor<ArrayList<Integer>> executor = new MainExecutor<>();
        IntStream.range(0, 10).forEach((i) -> executor.addTask(new SimpleTask(ArrayList.class)));

        Assert.assertEquals(10, executor.getTaskCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addTaskWithoutValidatorException() {

        MainExecutor<ArrayList<Integer>> executor = new MainExecutor<>();
        SimpleTask task = new SimpleTask(ArrayList.class);
        task.execute();
        executor.addTask(task);
    }

    @Test
    public void addTask1() throws Exception {

    }

    @Test
    public void getValidResults() throws Exception {

    }

    @Test
    public void getInvalidResults() throws Exception {

    }

}