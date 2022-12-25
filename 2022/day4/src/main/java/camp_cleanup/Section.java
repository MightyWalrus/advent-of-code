package camp_cleanup;

import java.util.ArrayList;
import java.util.Collection;

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

  static boolean fullyContainsAny(Collection<Section> sections) {
    ArrayList<Section> sectionList = new ArrayList<>(sections);
    for (int i = 0; i < sectionList.size(); i++) {
      Section section = sectionList.get(i);
      for (int j = 0; j < sectionList.size(); j++) {
        if (i != j && section.fullyContainsOther(sectionList.get(j))) {
          return true;
        }
      }
    }
    return false;
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
