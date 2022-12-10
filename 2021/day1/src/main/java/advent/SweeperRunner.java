package advent;

import java.util.List;

public class SweeperRunner {

  public static int run(List<Integer> numbers) {
    int result = 0;
    for (int i = 1; i < numbers.size(); i++) {
      boolean sweepResult = new SonarSweeper(numbers.get(i - 1), numbers.get(i)).sweep();
      if (sweepResult) {
        result++;
      }
    }
    return result;
  }
}
