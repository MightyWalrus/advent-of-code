package dive;

class SubmarinePosition {

  final int horizontal;
  final int vertical;

  SubmarinePosition() {
    this.horizontal = 0;
    this.vertical = 0;
  }

  SubmarinePosition(int horizontal, int vertical) {
    this.horizontal = horizontal;
    this.vertical = vertical;
  }

  int getScore() {
    return horizontal * vertical;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubmarinePosition position = (SubmarinePosition) o;
    return horizontal == position.horizontal && vertical == position.vertical;
  }
}
