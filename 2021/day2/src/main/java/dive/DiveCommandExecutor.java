package dive;

import java.util.Stack;

class DiveCommandExecutor {

  static SubmarinePosition execute(Stack<DiveCommand> commands, SubmarinePosition position) {
    if (commands.isEmpty()) {
      return position;
    }
    DiveCommand command = commands.pop();
    // recursion
    return execute(commands, execute(command, position));
  }

  static SubmarinePosition execute(DiveCommand command, SubmarinePosition position) {
    return command.apply(position);
  }

  static SubmarinePosition executeWithAim(Stack<DiveCommand> commands, SubmarinePosition position) {
    if (commands.isEmpty()) {
      return position;
    }
    DiveCommand command = commands.pop();
    // recursion
    return executeWithAim(commands, executeWithAim(command, position));
  }

  static SubmarinePosition executeWithAim(DiveCommand command, SubmarinePosition position) {
    return command.applyWithAim(position);
  }
}
