package advent;

import java.util.Collection;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SweeperFeederTest {

    // [UnitOfWork_StateUnderTest_ExpectedBehavior]
    @Test
    public void test() {
        // GIVEN
        String fileName = "day1-input-small.txt";
        SweeperFeeder sweeperFeeder = new SweeperFeeder(fileName);
        // WHEN
        Collection<Integer> result = sweeperFeeder.feed();
        // THEN
        Assertions.assertThat(result).containsExactly(
                199,
                200,
                208,
                210,
                200,
                207,
                240,
                269,
                260,
                263);
    }
}
