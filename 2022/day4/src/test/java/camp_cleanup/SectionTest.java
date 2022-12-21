package camp_cleanup;

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

}