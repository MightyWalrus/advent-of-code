package camp_cleanup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CleanupSectionsParser {

  static Map<Integer, Collection<Section>> parse(String resource) {
    Map<Integer, Collection<Section>> sectionsMap = new HashMap<>();
    try (
        InputStream is = CleanupSectionsParser.class.getClassLoader().getResourceAsStream(resource);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr)) {
      int sectionsGroup = 1;
      String line = br.readLine();
      while (line != null) {
        sectionsMap.put(sectionsGroup++, parseSectionsString(line));
        line = br.readLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return sectionsMap;
  }

  private static Collection<Section> parseSectionsString(String input) {
    String[] sectionStrings = input.split(",");
    return Arrays.stream(sectionStrings)
        .map(ss -> Section.fromRangeString(ss))
        .collect(Collectors.toList());
  }

}
