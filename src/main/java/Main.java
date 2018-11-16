import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Stream.of(
            new EventListener("apple", "I love macbooks"),
            new EventListener("java", "I could go for some coffee")
        ).forEach(Thread::start);

        Stream<String> inStream = Stream.generate(new Scanner(System.in)::nextLine);

        boolean status = inStream.anyMatch(Main::passValue);
    }

    private static boolean passValue(String input) {
        EventTracker.getInstance().push(input);
        return input.equals("quit");
    }

}
