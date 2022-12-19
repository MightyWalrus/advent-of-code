package rucksack_reorg;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ItemScoreCalculatorTest {

  @ParameterizedTest
  @CsvSource({
      "a, 1",
      "z, 26",
      "A, 27",
      "Z, 52"})
  public void calcReturnsScoreForSingleValidCharacters(char item, int expectedScore) {
    // GIVEN Params
    // WHEN
    int calculatedScore = ItemScoreCalculator.calc(item);
    // THEN
    Assertions.assertThat(calculatedScore).isEqualTo(expectedScore);
  }

}