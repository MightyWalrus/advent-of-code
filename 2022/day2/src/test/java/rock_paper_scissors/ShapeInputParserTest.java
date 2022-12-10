package rock_paper_scissors;

import java.util.Collection;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

class ShapeInputParserTest {

  // [UnitOfWork_StateUnderTest_ExpectedBehavior]
  @Test
  public void test() {
    // GIVEN
    String resource = "strategy-input.txt";
    Collection<Pair<Shape, Shape>> expectedShapePairs = List.of(
        new Pair<>(Shape.SCISSORS, Shape.SCISSORS),
        new Pair<>(Shape.PAPER, Shape.SCISSORS),
        new Pair<>(Shape.ROCK, Shape.ROCK));
    // WHEN
    Collection<Pair<Shape, Shape>> shapePairs = ShapeInputParser.parseShapesResource(resource);
    // THEN
    Assertions.assertThat(shapePairs.size()).isEqualTo(3);
    Assertions.assertThat(shapePairs).containsAll(expectedShapePairs);
  }

}