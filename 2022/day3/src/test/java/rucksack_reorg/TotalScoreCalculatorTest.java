package rucksack_reorg;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TotalScoreCalculatorTest {

  @Test
  public void calcRucksackCompartmentsReturnsTotalScoreOfCommonCompartmentItems() {
    // GIVEN
    String resource = "rucksack-input.txt";
    int numberOfCompartments = 2;
    // WHEN
    int score = TotalScoreCalculator.calcRucksackCompartmentsScore(resource, numberOfCompartments);
    // THEN
    Assertions.assertThat(score).isEqualTo(ItemScoreCalculator.calc('w')
        + ItemScoreCalculator.calc('Q')
        + ItemScoreCalculator.calc('d'));
  }

  @Test
  public void calcGroupRucksacksReturnsTotalScoreOfCommonRucksackItems() {
    // GIVEN
    String resource = "rucksack-input.txt";
    int numberOfGroupMembers = 3;
    // WHEN
    int score = TotalScoreCalculator.calcGroupRucksacksScore(resource, numberOfGroupMembers);
    // THEN
    Assertions.assertThat(score).isEqualTo(ItemScoreCalculator.calc('W'));
  }

}