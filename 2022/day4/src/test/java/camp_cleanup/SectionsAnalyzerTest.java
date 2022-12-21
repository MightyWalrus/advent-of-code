package camp_cleanup;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SectionsAnalyzerTest {

  @Test
  public void analyzerCheckingParsedSectionsFindsNumberOfFullyContainedSections() {
    // GIVEN
    Map<Integer, Collection<Section>> parsedSections = Map.of(
        1, List.of(new Section(22, 65), new Section(22, 66)),
        2, List.of(new Section(91, 94), new Section(63, 91)),
        3, List.of(new Section(85, 86), new Section(64, 86)));
    // WHEN
    int count = SectionsAnalyzer.getNumberOfFullyContainedSections(parsedSections);
    // THEN
    Assertions.assertThat(count).isEqualTo(2);
  }

}