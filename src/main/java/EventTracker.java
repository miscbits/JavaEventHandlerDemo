import java.util.HashMap;
import java.util.Map;

public class EventTracker implements Tracker {

    private static EventTracker INSTANCE = new EventTracker();

    private Map<String, Integer> tracker;

    private EventTracker() {
        this.tracker = new HashMap<>();
    }

    synchronized public Map<String, Integer> tracker() {
        return tracker;
    }

    synchronized public static EventTracker getInstance() {
        return INSTANCE;
    }

    public EventTracker(Map<String, Integer> tracker) {
        this.tracker = tracker;
    }

    synchronized public void push(String message) {
        tracker.put(message, tracker.getOrDefault(message, 0) + 1);
    }

    synchronized public boolean has(String message) {
        return tracker.getOrDefault(message, 0) != 0;
    }

    synchronized public void handle(String message, EventHandler e) {
        tracker.put(message, tracker.getOrDefault(message, 1) - 1);
        e.handle();
    }
}
