import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        EventTracker tracker = new EventTracker();

        Stream.of(
            new EventListener("apple", "I love macbooks", tracker),
            new EventListener("java", "I could go for some coffee", tracker)
        ).forEach(Thread::start);


        Scanner in = new Scanner(System.in);
        Stream<String> inStream = Stream.generate(in::nextLine);

        boolean status = inStream.anyMatch((input) -> Main.passValue(input, tracker));
    }

    private static boolean passValue(String input, EventTracker tracker) {
        tracker.push(input);
        return input.equals("quit");
    }

}
