package rock_paper_scissors;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

class ShapeScoreCalculatorTest {

  @Test
  public void calculateTotalScoreByUsingShapePairsSummingUpSingleRoundResults() {
    // GIVEN
    int playerPosition = 1;
    Collection<Pair<Shape, Shape>> shapePairs = List.of(
        new Pair<>(Shape.SCISSORS, Shape.SCISSORS),
        new Pair<>(Shape.PAPER, Shape.SCISSORS),
        new Pair<>(Shape.PAPER, Shape.ROCK));
    // WHEN
    int totalScore = ShapeScoreCalculator.calcTotalScore(shapePairs, playerPosition);
    // THEN
    Assertions.assertThat(totalScore).isEqualTo((3 + 3) + (3 + 6) + (1 + 0));
  }
}