package dive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class DiveCommandInputParser {

  static Stack<DiveCommand> parse(String resource) {
    List<DiveCommand> commandList = new ArrayList<>();
    try (
        InputStream is = DiveCommandInputParser.class.getClassLoader()
            .getResourceAsStream(resource);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr)) {
      String line = br.readLine();
      while (line != null) {
        commandList.add(DiveCommand.from(line));
        line = br.readLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    Stack<DiveCommand> commands = new Stack<>();
    Collections.reverse(commandList);
    commands.addAll(commandList);
    return commands;
  }
}
