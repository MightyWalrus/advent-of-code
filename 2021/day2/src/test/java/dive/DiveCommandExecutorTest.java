package dive;

import java.util.List;
import java.util.Stack;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DiveCommandExecutorTest {

  private SubmarinePosition initPosition;
  private DiveCommand command1;
  private DiveCommand command2;
  private DiveCommand command3;

  @BeforeEach
  public void init() {
    initPosition = new SubmarinePosition();
    command1 = new DiveCommand.Forward(4);
    command2 = new DiveCommand.Down(3);
    command3 = new DiveCommand.Up(1);
  }

  @Test
  public void executeSingleDiveCommandsMovesSubmarinePositionCommandByCommand() {
    // GIVEN (init & test variables)
    // WHEN
    SubmarinePosition newPosition1 = DiveCommandExecutor.execute(command1, initPosition);
    SubmarinePosition newPosition2 = DiveCommandExecutor.execute(command2, newPosition1);
    SubmarinePosition endPosition = DiveCommandExecutor.execute(command3, newPosition2);
    // THEN
    Assertions.assertThat(initPosition).isEqualTo(new SubmarinePosition(0, 0));
    Assertions.assertThat(newPosition1).isEqualTo(new SubmarinePosition(4, 0));
    Assertions.assertThat(newPosition2).isEqualTo(new SubmarinePosition(4, 3));
    Assertions.assertThat(endPosition).isEqualTo(new SubmarinePosition(4, 2));
  }

  @Test
  public void executeAllDiveCommandsMovesSubmarineToEndPosition() {
    // GIVEN (init & test variables)
    Stack<DiveCommand> diveCommands = new Stack<>();
    diveCommands.addAll(List.of(command1, command2, command3));
    // WHEN
    SubmarinePosition endPosition = DiveCommandExecutor.execute(diveCommands, initPosition);
    // THEN
    Assertions.assertThat(initPosition).isEqualTo(new SubmarinePosition(0, 0));
    Assertions.assertThat(endPosition).isEqualTo(new SubmarinePosition(4, 2));
  }

}