package dive;

import java.util.List;
import java.util.Stack;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DiveCommandInputParserTest {

  // [UnitOfWork_StateUnderTest_ExpectedBehavior]
  @Test
  public void test() {
    // GIVEN
    String resource = "dive-commands.txt";
    // WHEN
    Stack<DiveCommand> diveCommands = DiveCommandInputParser.parse(resource);
    // THEN
    Assertions.assertThat(diveCommands).containsExactly(new DiveCommand.Forward(9), new DiveCommand.Down(12),
        new DiveCommand.Up(4), new DiveCommand.Down(5));
  }
}