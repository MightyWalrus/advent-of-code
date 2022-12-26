package sonar_sweeping;

import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("\n--- Advent of Code 2021 - Day 1: Sonar Sweeper ---\n");
        List<Integer> numbers = new SweeperFeeder("day1-input.txt").feed();

        int result = SweeperRunner.runSingleSweeper(numbers);
        System.out.println(String.format("Single Sweeper Result: %s times increased", result));

        result = SweeperRunner.runGroupSweeper(numbers, 3);
        System.out.println(String.format("Group Sweeper Result: %s times increased", result));
    }

}
