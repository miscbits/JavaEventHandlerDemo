import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.runMe();
    }

    private boolean passValue(String input, EventTracker tracker) {
        tracker.push(input);
        return input.equals("quit");
    }

    public void runMe() {
        EventTracker tracker = new EventTracker();

        new EventListener("apple", "I love macbooks", tracker).start();
        new EventListener("java", "I could go for some coffee", tracker).start();

        Stream<String> inStream = Stream.generate(new Scanner(System.in)::nextLine);

        inStream.anyMatch((input) -> this.passValue(input, tracker));
    }

}
