import java.util.Map;

public interface Tracker {

    Map<String, Integer> tracker();

    void push(String message);

    boolean has(String message);

    void handle(String message, EventHandler e);
}
