import java.util.LinkedList;
import java.util.List;

public class EventTracker {

    private List<String> tracker;

    public EventTracker() {
        this.tracker = new LinkedList<>();
    }

    public EventTracker(List<String> tracker) {
        this.tracker = tracker;
    }

    public void push(String message) {
        tracker.add(message);
    }

    public boolean has(String message) {
        return tracker.indexOf(message) != -1;
    }

    public void handle(String message, EventHandler e) {
        e.handle();
        tracker.remove(message);
    }
}
