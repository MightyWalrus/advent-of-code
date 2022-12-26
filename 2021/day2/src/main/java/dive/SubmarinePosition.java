package dive;

class SubmarinePosition {

  final int horizontal;
  final int vertical;
  final int aim;

  SubmarinePosition() {
    this(0, 0, 0);
  }

  SubmarinePosition(int horizontal, int vertical) {
    this(horizontal, vertical, 0);
  }

  SubmarinePosition(int horizontal, int vertical, int aim) {
    this.horizontal = horizontal;
    this.vertical = vertical;
    this.aim = aim;
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
