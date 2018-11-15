import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class EventTrackerTest {

    @Test
    public void instantiate() {
        EventTracker et = new EventTracker(new ArrayList<>());

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

        boolean trackerHasTest = eventTracker.has("test");

        Assert.assertTrue(trackerHasTest);
    }

    @Test
    public void has2() {
        List<String> testList = new ArrayList<>();
        testList.add("test");
        testList.add("folcrum");
        EventTracker eventTracker = new EventTracker(testList);

        boolean trackerHasTest = eventTracker.has("folcrum");

        Assert.assertTrue(trackerHasTest);
    }

    @Test
    public void handle() {
        List<String> testList = new ArrayList<>();
        testList.add("test");
        EventTracker eventTracker = new EventTracker(testList);

        eventTracker.handle("test", () -> {});

        boolean trackerHasTest = eventTracker.has("test");

        Assert.assertFalse(trackerHasTest);
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