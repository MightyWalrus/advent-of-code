package rucksack_reorg;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class RucksackScoreCalculator {

  static int calc(String resource, int numberOfCompartments) {
    Map<Integer, List<Collection<Character>>> parsedRucksackCompartments =
        RucksackCompartmentsParser.parseRucksackInput(resource, 2);
    int totalScore = parsedRucksackCompartments.values().stream()
        .map(list -> CommonItemsFinder.findCommon(list))
        .flatMap(col -> col.stream())
        .map(c -> ItemScoreCalculator.calc(c))
        .reduce(0, (total, score) -> total + score);
    return totalScore;
  }

}
