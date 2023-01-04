package tuning;

public class App {

  public static void main(String[] args) {
    System.out.println("\n--- Advent of Code 2022 - Day 6: Tuning Trouble ---\n");
    int firstMarker = SignalProcessor.firstMarkerAfter(args[0], 4);
    System.out.println(String.format("First marker after character: %s", firstMarker));
  }
}
