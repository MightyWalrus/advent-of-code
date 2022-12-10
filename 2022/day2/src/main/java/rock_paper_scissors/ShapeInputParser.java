package rock_paper_scissors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import org.javatuples.Pair;

public class ShapeInputParser {

  static Collection<Pair<Shape, Shape>> parseShapesResource(String resource) {
    Collection<Pair<Shape, Shape>> shapePairs = new ArrayList<>();
    try (
        InputStream is = ShapeInputParser.class.getClassLoader().getResourceAsStream(resource);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr)) {
      String line = br.readLine();
      while (line != null) {
        String[] split = line.split(" ");
        shapePairs.add(new Pair<>(Shape.fromSymbol(split[0]), Shape.fromSymbol(split[1])));
        line = br.readLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return shapePairs;
  }
}
