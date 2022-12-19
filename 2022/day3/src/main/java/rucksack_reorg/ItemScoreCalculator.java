package rucksack_reorg;

public class ItemScoreCalculator {

  static int calc(char item) {
    return Character.isLowerCase(item)
        ? item - 96 // a == 97 -> 1
        : item - 64 + 26; // A == 65 -> 27
  }

}
