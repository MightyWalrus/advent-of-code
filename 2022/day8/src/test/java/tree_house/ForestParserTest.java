package tree_house;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ForestParserTest {

  // [UnitOfWork_StateUnderTest_ExpectedBehavior]
  @Test
  public void test() {
    // GIVEN
    String resource = "forest.txt";
    int[][] trees = new int[][]{{3, 0, 3, 7, 3}, {2, 5, 5, 1, 2}, {6, 5, 3, 3, 2}, {3, 3, 5, 4, 9}};
    // WHEN
    Forest forest = ForestParser.parse(resource);
    // THEN
    Assertions.assertThat(forest.trees).isEqualTo(trees);
  }
}