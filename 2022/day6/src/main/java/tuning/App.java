package tuning;

public class App {

  public static void main(String[] args) {
    System.out.println("\n--- Advent of Code 2022 - Day 6: Tuning Trouble ---\n");
    if (args == null || args.length != 2 || !isInteger(args[0])) {
      System.out.println("Wrong usage! First provide the markerLength, then provide the signal...");
    }
    int firstMarker = SignalProcessor.firstMarkerAfter(args[1], Integer.valueOf(args[0]));
    System.out.println(String.format("First marker after character: %s", firstMarker));
  }

  private static boolean isInteger(String arg) {
    try {
      Integer.valueOf(arg);
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }
}
