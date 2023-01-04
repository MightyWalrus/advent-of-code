package tuning;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SignalProcessorTest {

  @ParameterizedTest
  @CsvSource({
      "ab, -1",
      "abcabc, -1",
      "abcd, 4",
      "abcdzzz, 4",
      "abcabddab, 6",
      "aaaabbbacdddd, 10"})
  public void paramTest(String signal, int expectedFirstMarker) {
    // GIVEN Params
    // WHEN
    int actualFirstMarker = SignalProcessor.firstMarkerAfter(signal, 4);
    // THEN
    Assertions.assertThat(actualFirstMarker).isEqualTo(expectedFirstMarker);
  }
}