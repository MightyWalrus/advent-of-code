package supply_stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CargoInitSetInputParser {

  static List<Stack<Character>> parse(String resource) {
    // input is basically reversed
    Stack<String> stackedInputLines = getLinesOfInputFileOnStack(resource);
    String stackNumberInput = stackedInputLines.pop();
    int numberOfStacks = getNumberOfStacks(stackNumberInput);
    List<Stack<Character>> stacks = createEmptyStacks(numberOfStacks);
    while (!stackedInputLines.isEmpty()) {
      String cratesInput = stackedInputLines.pop();
      addCratesToStacks(cratesInput, stacks);
    }
    return stacks;
  }

  private static List<Stack<Character>> addCratesToStacks(String cratesInput,
      List<Stack<Character>> stacks) {
    for (int i = 0; i < stacks.size(); i++) {
      // crate is 3 chars long ("actual char is in the middle") and separated by 1 char
      char crate = cratesInput.charAt(i * 4 + 1);
      if (!Character.isWhitespace(crate)) {
        stacks.get(i).push(crate);
      }
    }
    return stacks;
  }

  private static ArrayList<Stack<Character>> createEmptyStacks(int numberOfStacks) {
    ArrayList<Stack<Character>> cratesStacks = new ArrayList<>();
    for (int i = 0; i < numberOfStacks; i++) {
      cratesStacks.add(new Stack<>());
    }
    return cratesStacks;
  }

  private static int getNumberOfStacks(String stackNumberInput) {
    String[] splitStackNumberInput = stackNumberInput.split(" ");
    return Arrays.stream(splitStackNumberInput)
        .filter(str -> !str.trim().isEmpty())
        .mapToInt(str -> Integer.valueOf(str))
        .max()
        .orElse(0);
  }

  private static Stack<String> getLinesOfInputFileOnStack(String resource) {
    Stack<String> stack = new Stack<>();
    try (
        InputStream is = CargoInitSetInputParser.class.getClassLoader()
            .getResourceAsStream(resource);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr)) {
      String line = br.readLine();
      while (line != null) {
        stack.push(line);
        line = br.readLine();
      }
    } catch (
        IOException e) {
      e.printStackTrace();
    }
    return stack;
  }

}
