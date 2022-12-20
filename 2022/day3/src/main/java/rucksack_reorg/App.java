package rucksack_reorg;

public class App {

  public static void main(String[] args) {
    System.out.println("\n--- Advent of Code 2022 - Day 3: Rucksack Reorg ---\n");

    int score = TotalScoreCalculator.calcRucksackCompartmentsScore("rucksack-input.txt", 2);
    System.out.println(String.format("Total score/ sum of the priorities based on "
        + "common items in compartments: %s", score));

    score = TotalScoreCalculator.calcGroupRucksacksScore("rucksack-input.txt", 3);
    System.out.println(String.format("Total score/ sum of the priorities based on "
        + "common items in rucksacks: %s", score));
  }
}
