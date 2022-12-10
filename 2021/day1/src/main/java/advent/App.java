package advent;

import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Integer> numbers = new SweeperFeeder(args[0]).feed();
        int result = SweeperRunner.run(numbers);
        System.out.println(String.format("Sweep Result: %s times increased", result));
    }

}
