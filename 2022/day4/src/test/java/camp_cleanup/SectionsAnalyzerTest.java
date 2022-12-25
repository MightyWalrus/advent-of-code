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
    int betterCount = SectionsAnalyzer.getBetterNumberOfFullyContainedSections(parsedSections);
    // THEN
    Assertions.assertThat(count).isEqualTo(2);
    Assertions.assertThat(betterCount).isEqualTo(2);
  }

  @Test
  public void analyzerCheckingParsedSectionsFindsNumberOfOverlappingSections() {
    // GIVEN
    Map<Integer, Collection<Section>> parsedSections = Map.of(
        1, List.of(new Section(22, 65), new Section(22, 66)),
        2, List.of(new Section(91, 94), new Section(63, 91)),
        3, List.of(new Section(1, 3), new Section(5, 8)));
    // WHEN
    int count = SectionsAnalyzer.getterBetterNumberOfOverlappingSections(parsedSections);
    // THEN
    Assertions.assertThat(count).isEqualTo(2);
  }

}