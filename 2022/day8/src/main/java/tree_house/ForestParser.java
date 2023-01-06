package tree_house;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ForestParser {

  static Forest parse(String resource) {
    List<String> treeStrings = getTreeStrings(resource);
    return createForest(treeStrings);
  }

  private static List<String> getTreeStrings(String resource) {
    List<String> treeStrings = new ArrayList<>();
    try (
        InputStream is = ForestParser.class.getClassLoader()
            .getResourceAsStream(resource);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr)) {
      String line = br.readLine();
      while (line != null) {
        treeStrings.add(line);
        line = br.readLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return treeStrings;
  }

  private static Forest createForest(List<String> treeStrings) {
    int[][] trees = new int[treeStrings.size()][treeStrings.get(0).length()];
    for (int y = 0; y < treeStrings.size(); y++) {
      String treeStr = treeStrings.get(y);
      for (int x = 0; x < treeStr.length(); x++) {
        trees[y][x] = Integer.parseInt(treeStr.substring(x, x + 1));
      }
    }
    return new Forest(trees);
  }

}
