package camp_cleanup;

class Section {

  final int min;
  final int max;

  Section(int min, int max) {
    this.min = min;
    this.max = max;
  }

  static Section fromRangeString(String rangeString) {
    String[] ranges = rangeString.split("-");
    return new Section(Integer.valueOf(ranges[0]), Integer.valueOf(ranges[1]));
  }

  boolean fullyContainsOther(Section otherSection) {
    return this.min <= otherSection.min
        && this.max >= otherSection.max;
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof Section
        && this.min == ((Section) obj).min
        && this.max == ((Section) obj).max;
  }
}
