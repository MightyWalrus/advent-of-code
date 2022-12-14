package rock_paper_scissors;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ShapeTest {

  @ParameterizedTest
  @CsvSource({
      "A, ROCK", "X, ROCK",
      "B, PAPER", "Y, PAPER",
      "C, SCISSORS", "Z, SCISSORS"
  })
  public void usingKnownSymbolsReturnsMatchingShapes(String searchedSymbol, Shape expectedShape) {
    // GIVEN args
    // WHEN
    Shape foundShape = Shape.fromSymbol(searchedSymbol);
    // THEN
    Assertions.assertThat(foundShape).isEqualTo(expectedShape);
  }

  @ParameterizedTest
  @CsvSource({
      "A, X, SCISSORS",
      "A, Y, ROCK",
      "A, Z, PAPER"
  })
  public void usingKnownSymbolAndOutcomeAgainstReturnsMatchingShape(String shapeSymbol,
      String outcomeSymbol, Shape expectedShape) {
    // GIVEN args
    // WHEN
    Shape foundShape = Shape.fromOutcomeAgainst(outcomeSymbol, shapeSymbol);
    // THEN
    Assertions.assertThat(foundShape).isEqualTo(expectedShape);
  }

  @ParameterizedTest
  @CsvSource({
      "ROCK, ROCK, 4",
      "ROCK, PAPER, 1",
      "ROCK, SCISSORS, 7"
  })
  public void calcScoreOfOwnShapeAgainstOpponentBasedOnOwnScoreAndBattleResult(Shape myShape,
      Shape opponentShape, int expectedScore) {
    // GIVEN args
    // WHEN
    int score = myShape.scoreAgainst(opponentShape);
    // THEN
    Assertions.assertThat(score).isEqualTo(expectedScore);
  }

}