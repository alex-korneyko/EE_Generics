import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MainExecutor<T extends List<Integer>> implements Executor<T> {

    private List<TaskWithValidator> tasks = new ArrayList<>();

    @Override
    public void addTask(Task<? extends T> task) {
        if (task.isExecuted()) {
            throw new IllegalArgumentException("Task is executed");
        }

        tasks.add(new TaskWithValidator(task, result -> true));
    }

    @Override
    public void addTask(Task<? extends T> task, Validator<? super T> validator) {
        if (task.isExecuted()) {
            throw new IllegalArgumentException("Task is executed");
        }

        tasks.add(new TaskWithValidator(task, validator));
    }

    @Override
    public void execute() {
        tasks.forEach(taskSet -> taskSet.task.execute());
    }

    @Override
    public List<T> getValidResults() {
        List<T> validResults = new ArrayList<>();

        IntStream.range(0, tasks.size()).forEach((i) -> {
            Task<? extends T> task = tasks.get(i).task;

            if (!task.isExecuted()) {
                throw new IllegalArgumentException("Task is not executed");
            }

            if (tasks.get(i).validator.isValid(task.getResult())) {
                validResults.add(task.getResult());
            }
        });

        return validResults;
    }

    @Override
    public List<T> getInvalidResults() {
        List<T> inValidResults = new ArrayList<>();

        IntStream.range(0, tasks.size()).forEach((i) -> {
            Task<? extends T> task = tasks.get(i).task;

            if (!task.isExecuted()) {
                throw new IllegalArgumentException("Task is not executed");
            }

            if (!tasks.get(i).validator.isValid(task.getResult())) {
                inValidResults.add(task.getResult());
            }
        });

        return inValidResults;
    }

    public int getTaskCount(){
        return tasks.size();
    }

    private class TaskWithValidator {
        TaskWithValidator(Task<? extends T> task, Validator<? super T> validator) {
            this.task = task;
            this.validator = validator;
        }

        Task<? extends T> task;
        Validator<? super T> validator;
    }
}
