package tree_house;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ForestTest {

  static Forest forest;

  @BeforeAll
  public static void init() {
    int[][] trees = new int[][]{{3, 0, 3, 7, 3}, {2, 5, 5, 1, 2}, {6, 5, 3, 3, 2}, {3, 3, 5, 4, 9}};
    forest = new Forest(trees);
  }

  // [UnitOfWork_StateUnderTest_ExpectedBehavior]
  @Test
  public void test() {
    // GIVEN (field)
    // WHEN
    int edgeTrees = forest.getEdgeTrees();
    // THEN
    Assertions.assertThat(edgeTrees).isEqualTo(5 + 5 + (2 * 2));
  }

  // [UnitOfWork_StateUnderTest_ExpectedBehavior]
  @Test
  public void test2() {
    // GIVEN (field)
    // WHEN
    int visibleInnerTrees = forest.getVisibleInnerTrees();
    // THEN
    Assertions.assertThat(visibleInnerTrees).isEqualTo(4);
  }

  // [UnitOfWork_StateUnderTest_ExpectedBehavior]
  @Test
  public void test3() {
    // GIVEN (field)
    // WHEN
    boolean hiddenByUpper = forest.isHiddenByUpper(1, 1);
    // THEN
    Assertions.assertThat(hiddenByUpper).isFalse();
  }

  // [UnitOfWork_StateUnderTest_ExpectedBehavior]
  @Test
  public void test4() {
    // GIVEN (field)
    // WHEN
    boolean hiddenByUpper = forest.isHiddenByDowner(1, 1);
    // THEN
    Assertions.assertThat(hiddenByUpper).isTrue();
  }

  // [UnitOfWork_StateUnderTest_ExpectedBehavior]
  @Test
  public void test5() {
    // GIVEN (field)
    // WHEN
    boolean hiddenByUpper = forest.isHiddenByRighter(1, 1);
    // THEN
    Assertions.assertThat(hiddenByUpper).isTrue();
  }

  // [UnitOfWork_StateUnderTest_ExpectedBehavior]
  @Test
  public void test6() {
    // GIVEN (field)
    // WHEN
    boolean hiddenByUpper = forest.isHiddenByLefter(1, 1);
    // THEN
    Assertions.assertThat(hiddenByUpper).isFalse();
  }

}