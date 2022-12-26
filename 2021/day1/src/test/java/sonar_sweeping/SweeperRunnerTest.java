package sonar_sweeping;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class SweeperRunnerTest {

  @Test
  public void runSingleSweepsReturnsIncreaseCountForEachEntry() {
    // GIVEN
    List<Integer> numbers = List.of(199,
        199,
        200, // increased
        208, // increased
        210, // increased
        200,
        207, // increased
        240, // increased
        269, // increased
        260,
        263); // increased
    // WHEN
    int result = SweeperRunner.runSingleSweeper(numbers);
    // THEN
    assertEquals(7, result);
  }

  @Test
  public void runGroupSweepsReturnsIncreaseCountForEachCompleteGroup() {
    // GIVEN
    List<Integer> numbers = List.of(199,
        199, // increased (group 2)
        200, // increased (group 3)
        208,
        210,
        200, // increased (group 6)
        207,
        240);
    // WHEN
    int result = SweeperRunner.runGroupSweeper(numbers, 3);
    // THEN
    assertEquals(3, result);
  }

}