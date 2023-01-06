package tree_house;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TreeCheckResultTest {

  @Test
  public void getTotalScenicScoreFromTreeCheckResultsContainingSingleZeroIsZero() {
    // GIVEN
    TreeCheckResult[] results = new TreeCheckResult[]{
        new TreeCheckResult(),
        new TreeCheckResult(true, 2),
        new TreeCheckResult(false, 3)};
    // WHEN
    int total = TreeCheckResult.totalScenicScore(results);
    // THEN
    Assertions.assertThat(total).isEqualTo(0);
  }

  @Test
  public void getTotalScenicScoreFromTreeCheckResultsIsTheMultiplicationOfTheSingleScores() {
    // GIVEN
    TreeCheckResult[] results = new TreeCheckResult[]{
        new TreeCheckResult(false, 3),
        new TreeCheckResult(false, 2),
        new TreeCheckResult(true, 1),
        new TreeCheckResult(true, 2)};
    // WHEN
    int total = TreeCheckResult.totalScenicScore(results);
    // THEN
    Assertions.assertThat(total).isEqualTo(12);
  }

}