package rock_paper_scissors;

import java.util.Collection;
import org.javatuples.Pair;

public class App {

  public static void main(String[] args) {
    System.out.println("\n--- Advent of Code 2022 - Day 2: Rock Paper Scissors ---\n");
    Collection<Pair<Shape, Shape>> shapePairs = ShapeInputParser.parseShapesResourceByShapeSymbols(
        "strategy-input.txt");
    int totalScore = ShapeScoreCalculator.calcTotalScore(shapePairs, 1);
    System.out.println(String.format("Your total score is: %s\n", totalScore));

    System.out.println("\n--- Using other strategy (by outcome) ---\n");
    shapePairs = ShapeInputParser.parseShapesResourceByShapeSymbolAndOutcome("strategy-input.txt");
    totalScore = ShapeScoreCalculator.calcTotalScore(shapePairs, 1);
    System.out.println(String.format("Your total score would be now: %s\n", totalScore));
  }
}
