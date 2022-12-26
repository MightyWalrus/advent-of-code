package dive;

import java.util.Objects;

abstract class DiveCommand {

  final int units;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DiveCommand command = (DiveCommand) o;
    return units == command.units;
  }

  @Override
  public int hashCode() {
    return Objects.hash(units);
  }

  static DiveCommand from(String commandString) {
    DiveCommand command = new Forward(0);
    String[] split = commandString.split(" ");
    switch (split[0].toLowerCase()) {
      case "forward":
        command = new Forward(Integer.valueOf(split[1]));
        break;
      case "down":
        command = new Down(Integer.valueOf(split[1]));
        break;
      case "up":
        command = new Up(Integer.valueOf(split[1]));
        break;
    }
    return command;
  }

  abstract SubmarinePosition apply(SubmarinePosition position);

  DiveCommand(int units) {
    this.units = units;
  }

  static class Forward extends DiveCommand {

    @Override
    SubmarinePosition apply(SubmarinePosition position) {
      return new SubmarinePosition(position.horizontal + units, position.vertical);
    }

    Forward(int unit) {
      super(unit);
    }
  }

  static class Down extends DiveCommand {

    Down(int unit) {
      super(unit);
    }

    @Override
    SubmarinePosition apply(SubmarinePosition position) {
      return new SubmarinePosition(position.horizontal, position.vertical + units);
    }
  }

  static class Up extends DiveCommand {

    Up(int unit) {
      super(unit);
    }

    @Override
    SubmarinePosition apply(SubmarinePosition position) {
      return new SubmarinePosition(position.horizontal, position.vertical - units);
    }
  }

}
