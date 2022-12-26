package sonar_sweeping;

import java.util.List;

public class SweeperRunner {

  public static int runSingleSweeper(List<Integer> numbers) {
    int result = 0;
    for (int i = 1; i < numbers.size(); i++) {
      boolean sweepResult = new SingleSonarSweeper(numbers.get(i - 1), numbers.get(i)).sweep();
      if (sweepResult) {
        result++;
      }
    }
    return result;
  }

  public static int runGroupSweeper(List<Integer> numbers, int sizeOfGroup) {
    int numberOfGroups = numbers.size() - (numbers.size() % sizeOfGroup);
    int result = 0;
    for (int i = 0; i < numberOfGroups - 1; i++) {
      boolean sweepResult = new GroupSonarSweeper(numbers.subList(i, i + sizeOfGroup),
          numbers.subList(i + 1, i + 1 + sizeOfGroup)).sweep();
      if (sweepResult) {
        result++;
      }
    }
    return result;
  }

}
