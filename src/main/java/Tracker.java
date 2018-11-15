import java.util.List;

public interface Tracker {

    List<String> tracker();

    void push(String message);

    boolean has(String message);

    void handle(String message, EventHandler e);
}
