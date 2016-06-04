/**
 * Created by Alex Korneyko on 04.06.2016.
 */
public class LongTask implements Task<Long> {

    Long value;
    Long result = 0L;

    public LongTask(Long value) {
        this.value = value;
    }

    @Override
    public void execute() {
        result = value + 20;
    }

    @Override
    public Long getResult() {
        return result;
    }
}
