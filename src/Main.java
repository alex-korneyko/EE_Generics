import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Написать фреймворк для последоватьного выполнения задач:
 * 1 Переписать интерфейс Task так что бы он был типизирован по результату (значению возращаемуому методом getResult()).
 * 2 Переписать интерфейс Validator так что бы он был типизирован по принемаемому значению isValid(Object result);
 * 3 Переписать интерфейс Executor так чтоб он был типизирован в соответсвии с с типизацией Task и Validator
 * 4 Импелементирвать интерфейс Executor
 * 5 Написать к нему тесты.
 *
 * Created by Alex Korneyko on 03.06.2016.
 */
public class Main {

    public static void main(String[] args) {

        MainExecutor<ArrayList<Integer>> executor = new MainExecutor<>();
        IntStream.range(0, 10_000).forEach((i) -> executor.addTask(new SimpleTask(ArrayList.class), new SimpleValidator<>()));
        executor.execute();

        List<ArrayList<Integer>> validResults = executor.getValidResults();
        List<ArrayList<Integer>> inValidResults = executor.getInvalidResults();

        System.out.println("\nValid results: " + validResults.size() + ". Invalid results: " + inValidResults.size());
        validResults.forEach(System.out::println);

    }

}
