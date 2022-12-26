package supply_stacks;

import java.util.List;
import java.util.Stack;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CargoInitSetInputParserTest {

  @Test
  public void parseInitCargoInputIntoListOfStacksContainingCargo() {
    // GIVEN
    String resource = "init-cargo.txt";
    // WHEN
    List<Stack<Character>> stacks = CargoInitSetInputParser.parseInitCargoSet(resource);
    // THEN
    Assertions.assertThat(stacks.size()).isEqualTo(9);
    Assertions.assertThat(stacks.stream()
        .mapToInt(stack -> stack.size())
        .max().orElseThrow()).isEqualTo(8);
    Assertions.assertThat(stacks.stream()
        .mapToInt(stack -> stack.size())
        .min().orElseThrow()).isEqualTo(3);
    Assertions.assertThat(stacks.get(1)).containsExactly('D', 'W', 'B');
  }

}