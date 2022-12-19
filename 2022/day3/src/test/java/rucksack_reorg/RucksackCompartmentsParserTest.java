package rucksack_reorg;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RucksackCompartmentsParserTest {

  @Test
  public void parseValidRucksackInputIntoMapContainingEachRucksacksCompartments() {
    // GIVEN
    String resource = "rucksack-input.txt";
    int numberOfCompartments = 2;
    // WHEN
    Map<Integer, List<Collection<Character>>> parsedRucksackCompartments =
        RucksackCompartmentsParser.parseRucksackInput(resource, numberOfCompartments);
    // THEN
    Assertions.assertThat(parsedRucksackCompartments.size()).isEqualTo(3);
    Assertions.assertThat(parsedRucksackCompartments.values().stream()
        .allMatch(list -> list.size() == 2)).isTrue();
    Assertions.assertThat(parsedRucksackCompartments.get(1).stream()
        .allMatch(col -> col.size() == 9)).isTrue();
    Assertions.assertThat(parsedRucksackCompartments.get(1).get(0))
        .containsAll(List.of('G', 'w', 'r'));
    Assertions.assertThat(parsedRucksackCompartments.get(1).get(1))
        .containsAll(List.of('Z', 'F', 'R'));
  }

}