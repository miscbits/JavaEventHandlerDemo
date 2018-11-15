import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        EventListener appleListener = new EventListener("apple", "I love macbooks");
        EventListener javaListener = new EventListener("java", "I could go for some coffee");

        appleListener.start();
        javaListener.start();

        Scanner in = new Scanner(System.in);
        Stream<String> inStream = Stream.generate(in::nextLine);

        boolean status = inStream.anyMatch(Main::passValue);
        in.close();
    }

    private static boolean passValue(String input) {
        EventTracker.getInstance().push(input);
        return input.equals("quit");
    }

}
