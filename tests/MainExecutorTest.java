import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class MainExecutorTest {

    @Test
    public void addTaskWithoutValidator() {

        MainExecutor<ArrayList<Integer>> executor = new MainExecutor<>();
        IntStream.range(0, 10).forEach((i) -> executor.addTask(new SimpleTask(ArrayList.class)));

        assertEquals(10, executor.getTaskCount());

    }

    @Test(expected = IllegalArgumentException.class)
    public void addTaskWithoutValidatorException() {

        MainExecutor<ArrayList<Integer>> executor = new MainExecutor<>();
        SimpleTask task = new SimpleTask(ArrayList.class);
        task.execute();
        executor.addTask(task);

    }

    @Test
    public void addTaskWithValidator() throws Exception {

        MainExecutor<ArrayList<Integer>> executor = new MainExecutor<>();
        IntStream.range(0, 10).forEach((i) -> executor.addTask(new SimpleTask(ArrayList.class), new SimpleValidator<>()));

        assertEquals(10, executor.getTaskCount());

    }

    @Test
    public void getValidResultsWithoutValidator() throws Exception {

        MainExecutor<ArrayList<Integer>> executor = new MainExecutor<>();
        IntStream.range(0, 10).forEach((i) -> executor.addTask(new SimpleTask(ArrayList.class)));
        executor.execute();

        executor.getValidResults().forEach(System.out::println);

    }

    @Test
    public void getValidAndInvalidResultsWithValidator() throws Exception {
        MainExecutor<ArrayList<Integer>> executor = new MainExecutor<>();
        IntStream.range(0, 10_000).forEach((i) -> executor.addTask(new SimpleTask(ArrayList.class), new SimpleValidator<>()));
        executor.execute();

        List<ArrayList<Integer>> validResults = executor.getValidResults();
        List<ArrayList<Integer>> inValidResults = executor.getInvalidResults();

        for(ArrayList<Integer> arrayList: validResults){
            assertEquals(45, arrayList.stream().mapToInt(value -> value).sum());
        }

        System.out.println("\nValid results: " + validResults.size() + ". Invalid results: " + inValidResults.size());
        validResults.forEach(System.out::println);

    }

}