package supply_stacks;

import java.util.List;
import java.util.Stack;
import supply_stacks.CargoOperation.MoveOperation;

public class App {

  public static void main(String[] args) {
    System.out.println("\n--- Advent of Code 2022 - Day 5: Supply Stacks ---\n");
    List<Stack<Character>> stacks = CargoInitSetInputParser.parse("init-cargo.txt");
    List<MoveOperation> moveOperations = CargoOperationInputParser.parse("cargo-rearrange-ops.txt");
    CargoOperator.move(moveOperations, stacks);
    String topCratesString = CargoOperator.getTopOfStacksAsString(stacks);
    System.out.println(String.format("Crates on top of Stacks: %s", topCratesString));
  }
}
