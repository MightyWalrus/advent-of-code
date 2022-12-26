package dive;

import java.util.Stack;
import java.util.stream.Collectors;

public class App {

  public static void main(String[] args) {
    System.out.println("\n--- Advent of Code 2021 - Day 2: Dive! ---\n");
    Stack<DiveCommand> originalDiveCommands = DiveCommandInputParser.parse("dive-commands.txt");

    Stack<DiveCommand> diveCommands = new Stack<>();
    diveCommands.addAll(originalDiveCommands.stream().collect(Collectors.toList()));
    SubmarinePosition endPosition = DiveCommandExecutor.execute(diveCommands, new SubmarinePosition());
    System.out.println(String.format("Submarine´s final position: %s/%s", endPosition.horizontal, endPosition.vertical));
    System.out.println(String.format("The position score is: %s", endPosition.getScore()));

    diveCommands = new Stack<>();
    diveCommands.addAll(originalDiveCommands.stream().collect(Collectors.toList()));
    endPosition = DiveCommandExecutor.executeWithAim(diveCommands, new SubmarinePosition());
    System.out.println(String.format("Submarine´s final position with aim: %s/%s", endPosition.horizontal, endPosition.vertical));
    System.out.println(String.format("The position score with aim is: %s", endPosition.getScore()));
  }

}
