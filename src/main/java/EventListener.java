public class EventListener extends Thread {

    private String messageToListenFor;
    private String messageToReplyWith;
    private EventTracker eventTracker;

    public EventListener(String message, String reply, EventTracker tracker) {
        this.messageToListenFor = message;
        this.messageToReplyWith = reply;
        this.eventTracker = tracker;
    }

    public void run() {
        while (!readToQuit())
            if (shouldReply())
                reply();
    }

    public boolean readToQuit() {
        return eventTracker.has("quit");
    }

    public boolean shouldReply() {
        return eventTracker.has(messageToListenFor);
    }

    public void reply() {
        eventTracker.handle(messageToListenFor,
                () -> System.out.println(messageToReplyWith));
    }
}
