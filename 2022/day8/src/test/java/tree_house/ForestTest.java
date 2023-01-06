package tree_house;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ForestTest {

  static Forest forest;

  @BeforeAll
  public static void init() {
    int[][] trees = new int[][]{{3, 0, 3, 7, 3}, {2, 5, 5, 1, 2}, {6, 5, 3, 3, 2}, {3, 3, 5, 4, 9}};
    forest = new Forest(trees);
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
  public void getMaxScenicScoreFromForestReturnsMaxFromAnyTree() {
    // GIVEN (field)
    // WHEN
    int maxScenicScore = forest.getMaxScenicScore();
    // THEN
    Assertions.assertThat(maxScenicScore).isEqualTo(4);
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
  public void isHiddenByNorthernTreesShowsIfTheCheckedTreeIsHiddenFromThatSide() {
    // GIVEN (field)
    // WHEN
    boolean hiddenByUpper = forest.checkNorthernTrees(1, 1).hidden;
    // THEN
    Assertions.assertThat(hiddenByUpper).isFalse();
  }

  @Test
  public void isHiddenBySouthernTreesShowsIfTheCheckedTreeIsHiddenFromThatSide() {
    // GIVEN (field)
    // WHEN
    boolean hiddenByUpper = forest.checkSouthernTrees(1, 1).hidden;
    // THEN
    Assertions.assertThat(hiddenByUpper).isTrue();
  }

  @Test
  public void isHiddenByEasternTreesShowsIfTheCheckedTreeIsHiddenFromThatSide() {
    // GIVEN (field)
    // WHEN
    boolean hiddenByUpper = forest.checkEasternTrees(1, 1).hidden;
    // THEN
    Assertions.assertThat(hiddenByUpper).isTrue();
  }

  @Test
  public void isHiddenByWesternTreesShowsIfTheCheckedTreeIsHiddenFromThatSide() {
    // GIVEN (field)
    // WHEN
    boolean hiddenByUpper = forest.checkWesternTrees(1, 1).hidden;
    // THEN
    Assertions.assertThat(hiddenByUpper).isFalse();
  }

  @ParameterizedTest
  @CsvSource({
      "0, 2, 0",
      "1, 1, 1",
      "2, 0, 2",
  })
  public void getScenicScoreByNorthernTreesShowsHowFarTheCheckedTreeCanLookToThatSide(
      int y, int x, int expectedScenicScore) {
    // GIVEN (field)
    // WHEN
    int scenicScore = forest.checkNorthernTrees(y, x).scenicScore;
    // THEN
    Assertions.assertThat(scenicScore).isEqualTo(expectedScenicScore);
  }

  @ParameterizedTest
  @CsvSource({
      "0, 0, 2",
      "0, 3, 3",
      "3, 0, 0",
  })
  public void getScenicScoreBySouthernTreesShowsHowFarTheCheckedTreeCanLookToThatSide(
      int y, int x, int expectedScenicScore) {
    // GIVEN (field)
    // WHEN
    int scenicScore = forest.checkSouthernTrees(y, x).scenicScore;
    // THEN
    Assertions.assertThat(scenicScore).isEqualTo(expectedScenicScore);
  }

  @ParameterizedTest
  @CsvSource({
      "0, 0, 2",
      "0, 1, 1",
      "0, 4, 0",
  })
  public void getScenicScoreByEasternTreesShowsHowFarTheCheckedTreeCanLookToThatSide(
      int y, int x, int expectedScenicScore) {
    // GIVEN (field)
    // WHEN
    int scenicScore = forest.checkEasternTrees(y, x).scenicScore;
    // THEN
    Assertions.assertThat(scenicScore).isEqualTo(expectedScenicScore);
  }

  @ParameterizedTest
  @CsvSource({
      "0, 0, 0",
      "0, 1, 1",
      "0, 3, 3",
  })
  public void getScenicScoreByWesternTreesShowsHowFarTheCheckedTreeCanLookToThatSide(
      int y, int x, int expectedScenicScore) {
    // GIVEN (field)
    // WHEN
    int scenicScore = forest.checkWesternTrees(y, x).scenicScore;
    // THEN
    Assertions.assertThat(scenicScore).isEqualTo(expectedScenicScore);
  }

}