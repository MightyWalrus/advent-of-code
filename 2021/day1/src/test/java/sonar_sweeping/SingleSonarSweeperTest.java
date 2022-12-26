package sonar_sweeping;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SingleSonarSweeperTest {

    @Test
    public void comparingBiggerAgainstSmallerNumberReturnsTrue() {
        // GIVEN
        int number1 = 2;
        int number2 = 4;
        SingleSonarSweeper ss = new SingleSonarSweeper(number1, number2);
        // WHEN
        boolean result = ss.sweep();
        // THEN
        assertTrue(result);
    }

    @Test
    public void comparingSmallerAgainstBiggerNumberReturnsFalse() {
        // GIVEN
        int number1 = 4;
        int number2 = 2;
        SingleSonarSweeper ss = new SingleSonarSweeper(number1, number2);
        // WHEN
        boolean result = ss.sweep();
        // THEN
        assertFalse(result);
    }

    @Test
    public void comparingSameNumbersReturnsFalse() {
        // GIVEN
        int number1 = 4;
        int number2 = 4;
        SingleSonarSweeper ss = new SingleSonarSweeper(number1, number2);
        // WHEN
        boolean result = ss.sweep();
        // THEN
        assertFalse(result);
    }

}
