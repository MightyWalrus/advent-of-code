package rock_paper_scissors;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ShapeTest {

  // [UnitOfWork_StateUnderTest_ExpectedBehavior]
  @ParameterizedTest
  @CsvSource({
      "A, ROCK", "X, ROCK",
      "B, PAPER", "Y, PAPER",
      "C, SCISSORS", "Z, SCISSORS"
  })
  public void test(String searchedSymbol, Shape exptectedShape) {
    // GIVEN args
    // WHEN
    Shape foundShape = Shape.fromSymbol(searchedSymbol);
    // THEN
    Assertions.assertThat(foundShape).isEqualTo(exptectedShape);
  }

  // [UnitOfWork_StateUnderTest_ExpectedBehavior]
  @ParameterizedTest
  @CsvSource({
      "ROCK, ROCK, 4",
      "ROCK, PAPER, 1",
      "ROCK, SCISSORS, 7"
  })
  public void test2(Shape myShape, Shape oponentShape, int expectedScore) {
    // GIVEN args
    // WHEN
    int score = myShape.scoreAgainst(oponentShape);
    // THEN
    Assertions.assertThat(score).isEqualTo(expectedScore);
  }

}