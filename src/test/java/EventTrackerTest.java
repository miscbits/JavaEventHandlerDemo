import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class EventTrackerTest {

    @Test
    public void instantiate() {
        EventTracker et = new EventTracker();
        Assert.assertNotNull(et);
    }

    @Test
    public void push() {
        List<String> testList = new ArrayList<>();
        EventTracker eventTracker = new EventTracker(testList);

        eventTracker.push("test");

        Assert.assertEquals("test", testList.get(0));
    }

    @Test
    public void has() {
        List<String> testList = new ArrayList<>();
        testList.add("test");
        EventTracker eventTracker = new EventTracker(testList);

        Assert.assertTrue(eventTracker.has("test"));
    }

    @Test
    public void handle() {
        List<String> testList = new ArrayList<>();
        testList.add("test");
        EventTracker eventTracker = new EventTracker(testList);

        eventTracker.handle("test", () -> {});

        Assert.assertFalse(eventTracker.has("test"));
    }

    @Test
    public void handle2() {
        List<String> testList = new ArrayList<>();
        testList.add("test");
        testList.add("test");
        EventTracker eventTracker = new EventTracker(testList);

        eventTracker.handle("test", () -> {});

        Assert.assertTrue(eventTracker.has("test"));
    }
}