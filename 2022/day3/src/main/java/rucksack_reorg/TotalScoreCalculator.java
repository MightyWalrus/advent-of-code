package rucksack_reorg;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class TotalScoreCalculator {

  static int calcRucksackCompartmentsScore(String resource, int numberOfCompartments) {
    Map<Integer, List<Collection<Character>>> parsedRucksackCompartments =
        RucksackCompartmentsParser.parseRucksackInput(resource, numberOfCompartments);
    return calc(parsedRucksackCompartments);
  }

  static int calcGroupRucksacksScore(String resource, int numberOfGroupMembers) {
    Map<Integer, List<Collection<Character>>> parsedGroupRucksacks =
        RucksackCompartmentsParser.parseGroupInput(resource, numberOfGroupMembers);
    return calc(parsedGroupRucksacks);
  }

  private static int calc(Map<Integer, List<Collection<Character>>> input) {
    int totalScore = input.values().stream()
        .map(list -> CommonItemsFinder.findCommon(list))
        .flatMap(col -> col.stream())
        .map(c -> ItemScoreCalculator.calc(c))
        .reduce(0, (total, score) -> total + score);
    return totalScore;
  }

}
