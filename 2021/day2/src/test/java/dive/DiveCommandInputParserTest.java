package dive;

import java.util.Stack;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DiveCommandInputParserTest {

  @Test
  public void parseDiveCommandsInputIntoStackOfCommandObjects() {
    // GIVEN
    String resource = "dive-commands.txt";
    // WHEN
    Stack<DiveCommand> diveCommands = DiveCommandInputParser.parse(resource);
    // THEN
    Assertions.assertThat(diveCommands)
        .containsExactly(new DiveCommand.Down(5), new DiveCommand.Up(4),
            new DiveCommand.Down(12), new DiveCommand.Forward(9));
  }
}