package tree_house;

import java.util.Arrays;

public class Forest {

  final int[][] trees;

  public Forest(int[][] trees) {
    this.trees = trees;
  }

  public int getAllVisibleTrees() {
    return getEdgeTrees() + getVisibleInnerTrees();
  }

  public int getMaxScenicScore() {
    int maxScore = 0;
    for (int y = 1; y < trees.length - 1; y++) {
      for (int x = 1; x < trees[y].length - 1; x++) {
        int total = TreeCheckResult.totalScenicScore(
            checkNorthernTrees(y, x),
            checkEasternTrees(y, x),
            checkSouthernTrees(y, x),
            checkWesternTrees(y, x));
        maxScore = total > maxScore ? total : maxScore;
      }
    }
    return maxScore;
  }

  int getEdgeTrees() {
    return (trees.length - 2) * 2 + trees[0].length * 2;
  }

  int getVisibleInnerTrees() {
    int count = 0;
    for (int y = 1; y < trees.length - 1; y++) {
      for (int x = 1; x < trees[y].length - 1; x++) {
        if (!checkNorthernTrees(y, x).hidden || !checkEasternTrees(y, x).hidden
            || !checkSouthernTrees(y, x).hidden || !checkWesternTrees(y, x).hidden) {
          count++;
        }
      }
    }
    return count;
  }

  TreeCheckResult checkNorthernTrees(int startY, int x) {
    for (int y = startY - 1; y >= 0; y--) {
      if (trees[y][x] >= trees[startY][x]) {
        return new TreeCheckResult(true, startY - y);
      }
    }
    return new TreeCheckResult(false, startY);
  }

  TreeCheckResult checkSouthernTrees(int startY, int x) {
    for (int y = startY + 1; y < trees.length; y++) {
      if (trees[y][x] >= trees[startY][x]) {
        return new TreeCheckResult(true, y - startY);
      }
    }
    return new TreeCheckResult(false, (trees.length - 1) - startY);
  }

  TreeCheckResult checkEasternTrees(int y, int startX) {
    for (int x = startX + 1; x < trees[y].length; x++) {
      if (trees[y][x] >= trees[y][startX]) {
        return new TreeCheckResult(true, x - startX);
      }
    }
    return new TreeCheckResult(false, (trees[y].length - 1) - startX);
  }

  TreeCheckResult checkWesternTrees(int y, int startX) {
    for (int x = startX - 1; x >= 0; x--) {
      if (trees[y][x] >= trees[y][startX]) {
        return new TreeCheckResult(true, startX - x);
      }
    }
    return new TreeCheckResult(false, startX);
  }

}

class TreeCheckResult {

  boolean hidden;
  int scenicScore;

  public TreeCheckResult() {
    this(false, 0);
  }

  TreeCheckResult(boolean hidden, int scenicScore) {
    this.hidden = hidden;
    this.scenicScore = scenicScore;
  }

  static int totalScenicScore(TreeCheckResult... results) {
    return Arrays.stream(results)
        .map(result -> result.scenicScore)
        .reduce(1, (a, b) -> a * b);
  }
}
