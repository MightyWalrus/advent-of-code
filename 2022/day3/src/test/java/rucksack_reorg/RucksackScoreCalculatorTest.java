package rucksack_reorg;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RucksackScoreCalculatorTest {

  @Test
  public void calcReturnsTotalScoreOfCommonCompartmentItems() {
    // GIVEN
    String resource = "rucksack-input.txt";
    int numberOfCompartments = 2;
    // WHEN
    int score = RucksackScoreCalculator.calc(resource, numberOfCompartments);
    // THEN
    Assertions.assertThat(score).isEqualTo(ItemScoreCalculator.calc('w')
        + ItemScoreCalculator.calc('Q')
        + ItemScoreCalculator.calc('d'));
  }

}