package camp_cleanup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class SectionsAnalyzer {

  static int getNumberOfFullyContainedSections(Map<Integer, Collection<Section>> parsedSections) {
    int count = 0;
    outer:
    // "looping louie" approves!
    for (Integer group : parsedSections.keySet()) {
      List<Section> sections = new ArrayList<>(parsedSections.get(group));
      for (int i = 0; i < sections.size(); i++) {
        Section section = sections.get(i);
        for (int j = 0; j < sections.size(); j++) {
          if (i != j && section.fullyContainsOther(sections.get(j))) {
            count++;
            continue outer;
          }
        }
      }
    }
    return count;
  }

  static int getBetterNumberOfFullyContainedSections(Map<Integer, Collection<Section>> parsedSections) {
    return (int) parsedSections.entrySet().stream()
        .map(entry -> Section.fullyContainsAny(entry.getValue()))
        .filter(Boolean::booleanValue)
        .count();
  }

}
