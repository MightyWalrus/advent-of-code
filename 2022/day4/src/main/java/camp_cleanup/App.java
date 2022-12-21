package camp_cleanup;

import java.util.Collection;
import java.util.Map;

public class App {

  public static void main(String[] args) {
    System.out.println("\n--- Advent of Code 2022 - Day 4: Camp Cleanup ---\n");
    Map<Integer, Collection<Section>> parsedSections = CleanupSectionsParser.parse(
        "cleanup-sections.txt");
    System.out.println(String.format("Assignment pairs contain sections fully: %s",
        SectionsAnalyzer.getNumberOfFullyContainedSections(parsedSections)));
  }
}
