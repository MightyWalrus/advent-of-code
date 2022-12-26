package supply_stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import supply_stacks.CargoOperation.MoveOperation;

public class CargoOperationInputParser {

  static List<MoveOperation> parse(String resource) {
    ArrayList<MoveOperation> moveOperations = new ArrayList<>();
    try (
        InputStream is = CargoOperationInputParser.class.getClassLoader()
            .getResourceAsStream(resource);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr)) {
      String line = br.readLine();
      while (line != null) {
        moveOperations.add(from(line));
        line = br.readLine();
      }
    } catch (
        IOException e) {
      e.printStackTrace();
    }
    return moveOperations;
  }

  private static MoveOperation from(String operationString) {
    String moveStr = operationString.substring(operationString.indexOf("move"),
        operationString.indexOf("from") - 1);
    Integer numberOfCrates = Integer.valueOf(moveStr.replaceAll("\\D+", ""));
    String fromStr = operationString.substring(operationString.indexOf("from"),
        operationString.indexOf("to") - 1);
    Integer from = Integer.valueOf(fromStr.replaceAll("\\D+", ""));
    String toStr = operationString.substring(operationString.indexOf("to"),
        operationString.length());
    Integer to = Integer.valueOf(toStr.replaceAll("\\D+", ""));
    return new MoveOperation(numberOfCrates, from, to);
  }
}
