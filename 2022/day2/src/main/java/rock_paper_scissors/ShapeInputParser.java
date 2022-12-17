package rock_paper_scissors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;
import org.javatuples.Pair;

public class ShapeInputParser {

  static Collection<Pair<Shape, Shape>> parseShapesResourceByShapeSymbols(String resource) {
    return parse(resource,
        symbols -> Shape.fromSymbol(symbols[0]),
        symbols -> Shape.fromSymbol(symbols[1]));
  }

  static Collection<Pair<Shape, Shape>> parseShapesResourceByShapeSymbolAndOutcome(
      String resource) {
    return parse(resource,
        symbols -> Shape.fromSymbol(symbols[0]),
        symbols -> Shape.fromOutcomeAgainst(symbols[1], symbols[0]));
  }

  private static Collection<Pair<Shape, Shape>> parse(String resource,
      Function<String[], Shape> firstShapeParsing, Function<String[], Shape> secondShapeParsing) {
    Collection<Pair<Shape, Shape>> shapePairs = new ArrayList<>();
    try (
        InputStream is = ShapeInputParser.class.getClassLoader().getResourceAsStream(resource);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr)) {
      String line = br.readLine();
      while (line != null) {
        String[] split = line.split(" ");
        shapePairs.add(
            new Pair<>(firstShapeParsing.apply(split), secondShapeParsing.apply(split)));
        line = br.readLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return shapePairs;
  }
}
