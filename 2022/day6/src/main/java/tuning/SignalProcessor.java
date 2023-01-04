package tuning;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class SignalProcessor {

  static int firstMarkerAfter(String signal, int markerLength) {
    if (signal.isEmpty() || signal.length() < markerLength) {
      return -1;
    }

    Queue<Character> chars = getInitQueue(signal, markerLength);
    if (markerFound(markerLength, chars)) {
      return markerLength;
    }

    for (int i = markerLength; i < signal.length(); i++) {
      chars.remove();
      chars.add(signal.charAt(i));
      if (markerFound(markerLength, chars)) {
        return i + 1;
      }
    }
    return -1;
  }

  private static boolean markerFound(int markerLength, Queue<Character> chars) {
    return new HashSet<>(chars).size() == markerLength;
  }

  private static Queue<Character> getInitQueue(String signal, int markerLength) {
    Queue<Character> chars = new LinkedList<>();
    for (int i = 0; i < markerLength; i++) {
      chars.add(signal.charAt(i));
    }
    return chars;
  }
}
