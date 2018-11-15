import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EventListenerTest {

    @Test
    public void readToQuit() {
        TrackerMock tracker = new TrackerMock();
        EventListener el = new EventListener("test", "reply", tracker);

        Assert.assertTrue(el.readToQuit());
    }

    @Test
    public void shouldReply() {
        TrackerMock tracker = new TrackerMock();
        EventListener el = new EventListener("test", "reply", tracker);

        Assert.assertTrue(el.shouldReply());
    }

    @Test
    public void reply() {
        TrackerMock tracker = new TrackerMock();
        EventListener el = new EventListener("test", "reply", tracker);

        el.reply();

        Assert.assertTrue(tracker.eventWasHandled);
    }

    class TrackerMock extends EventTracker {

        public boolean itemWasPushed;
        public boolean eventWasHandled;
        @Override
        public void push(String message) {
            itemWasPushed = true;
        }

        @Override
        public boolean has(String message) {
            return true;
        }

        @Override
        public void handle(String message, EventHandler e) {
            eventWasHandled = true;
        }
    }
}