package dive;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DiveCommandTest {

  @ParameterizedTest
  @MethodSource("provideDiveCommandTestArgs")
  public void diveCommandCanBeCreatedFromValidCommandString(String commandString,
      DiveCommand expectedCommand) {
    // GIVEN Params
    // WHEN
    DiveCommand command = DiveCommand.from(commandString);
    // THEN
    Assertions.assertThat(command).isEqualTo(expectedCommand);
  }

  private static Stream<Arguments> provideDiveCommandTestArgs() {
    return Stream.of(
        Arguments.of("forward 9", new DiveCommand.Forward(9)),
        Arguments.of("down 5", new DiveCommand.Down(5)),
        Arguments.of("up 4", new DiveCommand.Up(4)));
  }

}