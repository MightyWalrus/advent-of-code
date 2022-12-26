package sonar_sweeping;

import java.util.Collection;

public class GroupSonarSweeper {

  private Collection<Integer> group1;
  private Collection<Integer> group2;

  public GroupSonarSweeper(Collection<Integer> group1, Collection<Integer> group2) {
    this.group1 = group1;
    this.group2 = group2;
  }

  public boolean sweep() {
    return group2.stream().mapToInt(Integer::intValue).sum()
        > group1.stream().mapToInt(Integer::intValue).sum();
  }

}
