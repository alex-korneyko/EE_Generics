import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex Korneyko on 04.06.2016.
 */
public class ExecutorImpl<T> implements Executor<Number> {
    List<Task<Number>> tasksForExecute;
    List<Task<Number>> validTasks = new ArrayList<>();
    List<Task<Number>> inValidTasks = new ArrayList<>();

    @Override
    public void addTask(Task task) {
        tasksForExecute.add(task);
    }

    @Override
    public void addTask(Task task, Validator validator) {
        task.execute();
        if(validator.isValid(task))
            validTasks.add(task);
        else
            inValidTasks.add(task);
    }

    @Override
    public void execute() {
        for (Task<Number> task: tasksForExecute){
            task.execute();
            validTasks.add(task);
        }

    }

    @Override
    public List<Task<Number>> getValidResults() {
        return validTasks;
    }

    @Override
    public List<Task<Number>> getInvalidResults() {
        return inValidTasks;
    }
}
