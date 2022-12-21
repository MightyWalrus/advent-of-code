package camp_cleanup;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CleanupSectionsParserTest {

  @Test
  public void parseValidSectionStringIntoParsedSectionsMap() {
    // GIVEN
    String resource = "cleanup-sections.txt";
    // WHEN
    Map<Integer, Collection<Section>> parsedSections = CleanupSectionsParser.parse(resource);
    // THEN
    Assertions.assertThat(parsedSections.size()).isEqualTo(4);
    Assertions.assertThat(parsedSections.values().stream()
        .allMatch(sections -> sections.size() == 2)).isTrue();
    Assertions.assertThat(parsedSections.get(1).containsAll(
        List.of(new Section(22, 65), new Section(22, 66)))).isTrue();
  }

}