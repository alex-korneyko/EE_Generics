import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Alex Korneyko on 03.06.2016.
 */
public class Main {

    public static void main(String[] args) {

        MainExecutor<ArrayList<Integer>> executor = new MainExecutor<>();
        IntStream.range(0, 10_000).forEach((i) -> executor.addTask(new SimpleTask<>(ArrayList.class), new SimpleValidator<>()));
        executor.addTask(new SimpleTask<>(ArrayList.class, new ArrayList<>(Arrays.asList(8, 1, 2, 3, 5))), new SimpleValidator<>());
        executor.addTask(new SimpleTask<>(ArrayList.class, new ArrayList<>(Arrays.asList(6, 1, 2, 4, 3, 5))), new SimpleValidator<>());
        executor.execute();

        List<ArrayList<Integer>> validResults = executor.getValidResults();
        List<ArrayList<Integer>> inValidResults = executor.getInvalidResults();

        System.out.println("\nValid results: " + validResults.size() + ". Invalid results: " + inValidResults.size());
        validResults.forEach(System.out::println);

    }

}
