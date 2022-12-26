package supply_stacks;

import java.util.List;
import java.util.Stack;
import supply_stacks.CargoOperation.MoveOperation;

public class CargoOperator {

  static String getTopOfStacksAsString(List<Stack<Character>> stacks) {
    return stacks.stream()
        .map(stack -> String.valueOf(stack.peek()))
        .reduce("", (concat, string) -> concat.concat(string));
  }

  static boolean move(List<MoveOperation> moveOps, List<Stack<Character>> stacks) {
    return moveOps.stream()
        .map(moveOp -> move(moveOp, stacks))
        .allMatch(Boolean::booleanValue);
  }

  private static boolean move(MoveOperation moveOp, List<Stack<Character>> stacks) {
    int numberOfCrates = moveOp.numberOfCrates;
    try {
      while (numberOfCrates-- > 0) {
        stacks.get(moveOp.to - 1).push(stacks.get(moveOp.from - 1).pop());
      }
      return true;
    } catch (Exception e) {
      return false;
    }
  }

}
