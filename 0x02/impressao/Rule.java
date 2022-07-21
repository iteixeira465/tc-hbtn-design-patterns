import java.util.function.Supplier;

public class Rule<T> {
    public Supplier<T> process;

    public Rule(Supplier<T> process) {
        setProcess(process);
    }

    public Supplier<T> getProcess() {
        return process;
    }

    public void setProcess(Supplier<T> process) {
        this.process = process;
    }

}