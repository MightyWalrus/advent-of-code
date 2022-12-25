package camp_cleanup;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SectionTest {

  @Test
  public void createSectionFromValidRangeString() {
    // GIVEN
    String rangeString = "22-65";
    // WHEN
    Section section = Section.fromRangeString(rangeString);
    // THEN
    Assertions.assertThat(section).isEqualTo(new Section(22, 65));
  }

  @Test
  public void sectionFullyContainsOtherIfWithinValueRange() {
    // GIVEN
    Section sectionOne = new Section(22, 65);
    Section sectionTwo = new Section(22, 66);
    // WHEN
    boolean oneContainsTwo = sectionOne.fullyContainsOther(sectionTwo);
    boolean twoContainsOne = sectionTwo.fullyContainsOther(sectionOne);
    // THEN
    Assertions.assertThat(oneContainsTwo).isFalse();
    Assertions.assertThat(twoContainsOne).isTrue();
  }

  @Test
  public void sectionOverlapsWithOtherIfOneValueIsWithinRange() {
    // GIVEN
    Section sectionOne = new Section(1, 3);
    Section sectionTwo = new Section(2, 4);
    // WHEN
    boolean oneOverlapsWithTwo = sectionOne.overlapsWithOther(sectionTwo);
    boolean twoOverlapsWithOne = sectionTwo.overlapsWithOther(sectionOne);
    // THEN
    Assertions.assertThat(oneOverlapsWithTwo).isTrue();
    Assertions.assertThat(twoOverlapsWithOne).isTrue();
  }

  @Test
  public void sectionsFullyContainAnyIfOneIsFullyContained() {
    // GIVEN
    Map<Integer, Collection<Section>> parsedSections = Map.of(
        1, List.of(new Section(22, 65), new Section(22, 66)),
        2, List.of(new Section(91, 94), new Section(63, 91)));
    // WHEN
    boolean shouldContain = Section.fullyContainsAny(parsedSections.get(1));
    boolean shouldNotContain = Section.fullyContainsAny(parsedSections.get(2));
    // THEN
    Assertions.assertThat(shouldContain).isTrue();
    Assertions.assertThat(shouldNotContain).isFalse();
  }

  @Test
  public void sectionsOverlapAnyIfOneIsOverlapping() {
    // GIVEN
    Map<Integer, Collection<Section>> parsedSections = Map.of(
        1, List.of(new Section(22, 65), new Section(22, 66)),
        2, List.of(new Section(91, 94), new Section(63, 91)),
        3, List.of(new Section(1, 5), new Section(6, 10)));
    // WHEN
    boolean shouldOverlap = Section.overlapsAny(parsedSections.get(1));
    boolean shouldAlsoOverlap = Section.overlapsAny(parsedSections.get(2));
    boolean shouldNotOverlap = Section.overlapsAny(parsedSections.get(3));
    // THEN
    Assertions.assertThat(shouldOverlap).isTrue();
    Assertions.assertThat(shouldAlsoOverlap).isTrue();
    Assertions.assertThat(shouldNotOverlap).isFalse();
  }

}