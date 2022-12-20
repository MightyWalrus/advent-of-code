package rucksack_reorg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RucksackCompartmentsParser {

  static Map<Integer, List<Collection<Character>>> parseRucksackInput(String resource,
      int numberOfCompartments) {
    Map<Integer, List<Collection<Character>>> rucksackCompartmentsMap = new HashMap<>();
    try (
        InputStream is = RucksackCompartmentsParser.class.getClassLoader()
            .getResourceAsStream(resource);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr)) {
      int ruckSack = 1;
      String line = br.readLine();
      while (line != null) {
        rucksackCompartmentsMap.put(ruckSack++, getCompartments(numberOfCompartments, line));
        line = br.readLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return rucksackCompartmentsMap;
  }

  static Map<Integer, List<Collection<Character>>> parseGroupInput(String resource,
      int numberOfGroupMembers) {
    Map<Integer, List<Collection<Character>>> groupRucksacksMap = new HashMap<>();
    try (
        InputStream is = RucksackCompartmentsParser.class.getClassLoader()
            .getResourceAsStream(resource);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr)) {
      String line = br.readLine();
      int group = 1;
      Collection<String> groupRucksacks = new ArrayList<>();
      while (line != null) {
        groupRucksacks.add(line);
        if (groupRucksacks.size() >= numberOfGroupMembers) {
          groupRucksacksMap.put(group++, groupRucksacks.stream()
              .map(rucksack -> mapStringToCollectionOfCharacters(rucksack))
              .collect(Collectors.toList()));
          groupRucksacks.clear();
        }
        line = br.readLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return groupRucksacksMap;
  }

  private static List<Collection<Character>> getCompartments(int numberOfCompartments, String line) {
    List<Collection<Character>> compartments = new ArrayList<>();
    int compartmentSize = line.length() / numberOfCompartments;
    for (int beginIndex = 0; beginIndex < line.length(); beginIndex = beginIndex + compartmentSize) {
      compartments.add(
          mapStringToCollectionOfCharacters(line.substring(beginIndex, beginIndex + compartmentSize)));
    }
    return compartments;
  }

  private static Collection<Character> mapStringToCollectionOfCharacters(String string) {
    return string.chars()
        .mapToObj(value -> (char) value)
        .collect(Collectors.toList());
  }

}
