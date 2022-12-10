package calorie_counting;

import java.util.Collection;
import java.util.Map;

import org.javatuples.Pair;

public class CalorieCounter {

    static Pair<Integer, Integer> getElfWithMostCalories(
        Map<Integer, Collection<Integer>> elvesWithCalories) {
            int maxCalories = 0;
            int elfWithMaxCalories = 0;
        for (Integer key : elvesWithCalories.keySet()) {
            int totalCalories = elvesWithCalories.get(key).stream()
                .reduce(0, (totalCal, singleCal) -> totalCal + singleCal);
            if (totalCalories > maxCalories) {
                maxCalories = totalCalories;
                elfWithMaxCalories = key;
            }
        }
        return new Pair<Integer,Integer>(elfWithMaxCalories, maxCalories);
    }
}
