package tree_house;

public class Forest {

  final int[][] trees;

  public Forest(int[][] trees) {
    this.trees = trees;
  }

  int getEdgeTrees() {
    return (trees.length - 2) * 2 + trees[0].length * 2;
  }

  int getVisibleInnerTrees() {
    int count = 0;
    for (int y = 1; y < trees.length - 1; y++) {
      for (int x = 1; x < trees[y].length - 1; x++) {
        if (!isHiddenByUpper(y, x) || !isHiddenByRighter(y, x)
            || !isHiddenByDowner(y, x) || !isHiddenByLefter(y, x)) {
          count++;
          continue;
        }
      }
    }
    return count;
  }

  boolean isHiddenByUpper(int startY, int x) {
    for (int y = startY - 1; y >= 0; y--) {
      if (trees[y][x] >= trees[startY][x]) {
        return true;
      }
    }
    return false;
  }

  boolean isHiddenByDowner(int startY, int x) {
    for (int y = startY + 1; y < trees.length; y++) {
      if (trees[y][x] >= trees[startY][x]) {
        return true;
      }
    }
    return false;
  }

  boolean isHiddenByRighter(int y, int startX) {
    for (int x = startX + 1; x < trees[y].length; x++) {
      if (trees[y][x] >= trees[y][startX]) {
        return true;
      }
    }
    return false;
  }

  boolean isHiddenByLefter(int y, int startX) {
    for (int x = startX - 1; x >= 0; x--) {
      if (trees[y][x] >= trees[y][startX]) {
        return true;
      }
    }
    return false;
  }

  int getAllVisibleTrees() {
    return getEdgeTrees() + getVisibleInnerTrees();
  }

}
