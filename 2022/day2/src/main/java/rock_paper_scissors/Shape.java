package rock_paper_scissors;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public enum Shape {
  ROCK(List.of("A", "X"), 1),
  PAPER(List.of("B", "Y"), 2),
  SCISSORS(List.of("C", "Z"), 3);

  static {
    ROCK.beatenBy = PAPER;
    PAPER.beatenBy = SCISSORS;
    SCISSORS.beatenBy = ROCK;
  }

  private Collection<String> symbols;
  private int points;
  private Shape beatenBy;

  Shape(Collection<String> symbols, int points) {
    this.symbols = symbols;
    this.points = points;
  }

  static Shape fromSymbol(String symbol) {
    return Arrays.stream(values())
        .filter(shape -> shape.symbols.contains(symbol))
        .findFirst()
        .orElse(null);
  }

  static Shape fromOutcomeAgainst(String outcome, String symbol) {
    return fromSymbol(symbol).getOpponentShapeByItsOutcome(outcome);
  }

  int scoreAgainst(Shape shape) {
    return this.points +
        (this == shape ? 3 : this.beatenBy == shape ? 0 : 6);
  }

  private Shape getOpponentShapeByItsOutcome(String symbol) {
    Shape shape = null;
    switch (symbol) {
      case "Z":
        shape = beatenBy;
        break;
      case "Y":
        shape = this;
        break;
      case "X":
        shape = Arrays.stream(Shape.values())
            .filter(s -> s.beatenBy == this)
            .findFirst()
            .orElse(null);
    }
    return shape;
  }

}
