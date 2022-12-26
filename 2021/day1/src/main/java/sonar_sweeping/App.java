package sonar_sweeping;

import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Integer> numbers = new SweeperFeeder("day1-input.txt").feed();
        int result = SweeperRunner.run(numbers);
        System.out.println(String.format("Sweep Result: %s times increased", result));
    }

}
