package dive;

import java.util.Stack;

public class App {

  public static void main(String[] args) {
    System.out.println("\n--- Advent of Code 2021 - Day 2: Dive! ---\n");
    Stack<DiveCommand> diveCommands = DiveCommandInputParser.parse("dive-commands.txt");
    SubmarinePosition endPosition = DiveCommandExecutor.execute(diveCommands, new SubmarinePosition());
    System.out.println(String.format("Submarine´s final position: %s/%s", endPosition.horizontal, endPosition.vertical));
    System.out.println(String.format("The position score is: %s", endPosition.getScore()));
  }

}
