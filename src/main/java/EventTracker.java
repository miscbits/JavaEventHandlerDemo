import java.util.LinkedList;
import java.util.List;

public class EventTracker implements Tracker {

    private static EventTracker INSTANCE = new EventTracker();

    private List<String> tracker;

    private EventTracker() {
        this.tracker = new LinkedList<>();
    }

    public List<String> tracker() {
        return tracker;
    }

    public static EventTracker getInstance() {
        return INSTANCE;
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
        tracker.remove(message);
        e.handle();
    }
}
