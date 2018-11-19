public class EventListener extends Thread {

    private String messageToListenFor;
    private String messageToReplyWith;
    private Tracker eventTracker;

    public EventListener(String message, String reply) {
        this(message, reply, EventTracker.getInstance());
    }

    public EventListener(String message, String reply, Tracker tracker) {
        this.messageToListenFor = message;
        this.messageToReplyWith = reply;
        this.eventTracker = tracker;
    }

    public void run() {
        while (!readyToQuit())
            if (shouldReply())
                reply();
    }

    public boolean readyToQuit() {
        return eventTracker.has("quit");
    }

    public boolean shouldReply() {
        return eventTracker.has(messageToListenFor);
    }

    public void reply() {
        EventHandler e = () -> System.out.println(messageToReplyWith);
        eventTracker.handle(messageToListenFor, e);
    }
}