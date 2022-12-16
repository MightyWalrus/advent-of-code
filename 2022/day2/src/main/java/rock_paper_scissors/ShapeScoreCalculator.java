package rock_paper_scissors;

import java.util.Collection;
import org.javatuples.Pair;

public class ShapeScoreCalculator {

  static int calcTotalScore(Collection<Pair<Shape, Shape>> shapePairs, int playerPosition) {
    return shapePairs.stream()
        .map(pair -> playerPosition == 0
            ? pair.getValue0().scoreAgainst(pair.getValue1())
            : pair.getValue1().scoreAgainst(pair.getValue0()))
        .reduce(0, (totalScore, score) -> totalScore + score);
  }

}
