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

  @Test
  public void getEdgeTreesFromForestReturnsCorrectAmount() {
    // GIVEN (field)
    // WHEN
    int edgeTrees = forest.getEdgeTrees();
    // THEN
    Assertions.assertThat(edgeTrees).isEqualTo(5 + 5 + (2 * 2));
  }

  @Test
  public void getVisibleInnerTreesFromForestReturnsTreeAmountVisibleFromAnySide() {
    // GIVEN (field)
    // WHEN
    int visibleInnerTrees = forest.getVisibleInnerTrees();
    // THEN
    Assertions.assertThat(visibleInnerTrees).isEqualTo(4);
  }

  @Test
  public void isHiddenByNorthernTreesShowsIfTheCheckedTreeIsHiddenFromThatSide() {
    // GIVEN (field)
    // WHEN
    boolean hiddenByUpper = forest.isHiddenByNorthernTrees(1, 1);
    // THEN
    Assertions.assertThat(hiddenByUpper).isFalse();
  }

  @Test
  public void isHiddenBySouthernTreesShowsIfTheCheckedTreeIsHiddenFromThatSide() {
    // GIVEN (field)
    // WHEN
    boolean hiddenByUpper = forest.isHiddenBySouthernTrees(1, 1);
    // THEN
    Assertions.assertThat(hiddenByUpper).isTrue();
  }

  @Test
  public void isHiddenByEasternTreesShowsIfTheCheckedTreeIsHiddenFromThatSide() {
    // GIVEN (field)
    // WHEN
    boolean hiddenByUpper = forest.isHiddenByEasternTrees(1, 1);
    // THEN
    Assertions.assertThat(hiddenByUpper).isTrue();
  }

  @Test
  public void isHiddenByWesternTreesShowsIfTheCheckedTreeIsHiddenFromThatSide() {
    // GIVEN (field)
    // WHEN
    boolean hiddenByUpper = forest.isHiddenByWesternTrees(1, 1);
    // THEN
    Assertions.assertThat(hiddenByUpper).isFalse();
  }

}