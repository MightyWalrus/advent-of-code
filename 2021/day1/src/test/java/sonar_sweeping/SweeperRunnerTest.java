package sonar_sweeping;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class SweeperRunnerTest {

  // [UnitOfWork_StateUnderTest_ExpectedBehavior]
  @Test
  public void test() {
    // GIVEN
    List<Integer> numbers = List.of(199,
        199,
        200,
        208,
        210,
        200,
        207,
        240,
        269,
        260,
        263);
    // WHEN
    int result = SweeperRunner.run(numbers);
    // THEN
    assertEquals(7, result);
  }

}