import java.util.List;

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


    }


    public static int rndGenerator() {
        return (int) (Math.random() * 20);
    }

    public void test(List<Task<Integer>> intTasks) {
        Executor<Number> numberExecutor = new ExecutorImpl<>();

        for (Task<Integer> intTask : intTasks) {
            numberExecutor.addTask(intTask);
        }
        numberExecutor.addTask(new LongTask(10L), new NumberValidator());

        numberExecutor.execute();

        System.out.println("Valid results:");
        for (Task task : numberExecutor.getValidResults()) {
            System.out.println(task.getResult());
        }
        System.out.println("Invalid results:");
        for (Task task : numberExecutor.getInvalidResults()) {
            System.out.println(task.getResult());
        }
    }
}
