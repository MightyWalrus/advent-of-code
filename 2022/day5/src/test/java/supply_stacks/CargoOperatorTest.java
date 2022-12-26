package supply_stacks;

import java.util.List;
import java.util.Stack;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import supply_stacks.CargoOperation.MoveOperation;

class CargoOperatorTest {

  private Stack<Character> stackOne;
  private Stack<Character> stackTwo;
  private Stack<Character> stackThree;
  private List<Stack<Character>> stacks;

  @BeforeEach
  public void init() {
    stackOne = new Stack<>();
    stackOne.addAll(List.of('A', 'B', 'C', 'D'));
    stackTwo = new Stack<>();
    stackTwo.addAll(List.of('F', 'G', 'H'));
    stackThree = new Stack<>();
    stackThree.addAll(List.of('X', 'Y', 'Z'));
    stacks = List.of(stackOne, stackTwo, stackThree);
  }

  @Test
  public void operatorReturnsTopOfStacksAsOneStringContainingCrates() {
    // GIVEN (init method/ class variables)
    // WHEN
    String cratesString = CargoOperator.getTopOfStacksAsString(stacks);
    // THEN
    Assertions.assertThat(cratesString).isEqualTo("DHZ");
  }

  @Test
  public void operatorMovesNumberOfCreatesBetweenStacksBasedOnOpsInput() {
    // GIVEN (init method/ class variables)
    // WHEN
    boolean successfulMoves = CargoOperator.move(List.of(
        new MoveOperation(2, 1, 2),
        new MoveOperation(1, 1, 3)), stacks);
    // THEN
    Assertions.assertThat(successfulMoves).isTrue();
    Assertions.assertThat(stackOne).containsExactly('A');
    Assertions.assertThat(stackTwo).containsExactly('F', 'G', 'H', 'D', 'C');
    Assertions.assertThat(stackThree).containsExactly('X', 'Y', 'Z', 'B');
  }

  @Test
  public void operatorMovesMultipleNumberOfCreatesBetweenStacksBasedOnOpsInput() {
    // GIVEN (init method/ class variables)
    // WHEN
    boolean successfulMoves = CargoOperator.moveMultiple(List.of(
        new MoveOperation(2, 1, 2),
        new MoveOperation(1, 1, 3)), stacks);
    // THEN
    Assertions.assertThat(successfulMoves).isTrue();
    Assertions.assertThat(stackOne).containsExactly('A');
    Assertions.assertThat(stackTwo).containsExactly('F', 'G', 'H', 'C', 'D');
    Assertions.assertThat(stackThree).containsExactly('X', 'Y', 'Z', 'B');
  }
}