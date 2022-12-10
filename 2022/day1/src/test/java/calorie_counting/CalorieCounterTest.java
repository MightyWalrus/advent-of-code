package calorie_counting;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

public class CalorieCounterTest {

    @Test
    public void counterCheckingDifferentElvesFindAndReturnsElfWithMostCalories() {
        // GIVEN
        Map<Integer, Collection<Integer>> elvesWithCalories = Map.of(
            1, List.of(1000, 2000, 500),
            2, List.of(1000),
            3, List.of(2000, 2000));
        // WHEN
        Pair<Integer, Integer> topElf = CalorieCounter.getElfWithMostCalories(elvesWithCalories);
        // THEN
        Assertions.assertThat(topElf.getValue0()).isEqualTo(3);
        Assertions.assertThat(topElf.getValue1()).isEqualTo(4000);
    }
}
