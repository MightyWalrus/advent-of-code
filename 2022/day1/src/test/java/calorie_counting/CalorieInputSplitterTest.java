package calorie_counting;

import java.util.Collection;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalorieInputSplitterTest {

    @Test
    public void splitContentOfValidCaloriesResouceReturnsElfCaloriesMap() {
        // GIVEN
        String resourcePath = "test-calories.txt";
        // WHEN
        Map<Integer, Collection<Integer>> elvesWithCalories = 
            CalorieInputSplitter.getElvesWithCalories(resourcePath);
        // THEN
        Assertions.assertThat(elvesWithCalories.size()).isEqualTo(3);
        Assertions.assertThat(elvesWithCalories.get(1).size()).isEqualTo(2);
    }
}
