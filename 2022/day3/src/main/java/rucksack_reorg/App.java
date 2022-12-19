package rucksack_reorg;

public class App {

  public static void main(String[] args) {
    System.out.println("\n--- Advent of Code 2022 - Day 3: Rucksack Reorg ---\n");
    int score = RucksackScoreCalculator.calc("rucksack-input.txt", 2);
    System.out.println(String.format("Total score/ sum of the priorities: %s", score));
  }
}
