package calorie_counting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.javatuples.Pair;

public class CalorieCounter {

    static Pair<Integer, Integer> getElfWithMostCalories(
            Map<Integer, Collection<Integer>> elvesWithCalories) {
        int maxCalories = 0;
        int elfWithMaxCalories = 0;
        for (Integer elf : elvesWithCalories.keySet()) {
            int totalCalories = elvesWithCalories.get(elf).stream()
                    .reduce(0, (totalCal, singleCal) -> totalCal + singleCal);
            if (totalCalories > maxCalories) {
                maxCalories = totalCalories;
                elfWithMaxCalories = elf;
            }
        }
        return new Pair<Integer, Integer>(elfWithMaxCalories, maxCalories);
    }

    static Map<Integer, Integer> getElvesWithMostCalories(Map<Integer, Collection<Integer>> elvesWithCalories,
            int numberOfTopElves) {
        Map<Integer, Integer> elvesWithTotalCalories = new HashMap<>();
        List<Integer> maxCalories = new ArrayList<>();
        for (Integer currentElf : elvesWithCalories.keySet()) {
            int caloriesOfCurrentElf = elvesWithCalories.get(currentElf).stream()
                    .reduce(0, (totalCal, singleCal) -> totalCal + singleCal);
            fillMaxCaloriesList(maxCalories, caloriesOfCurrentElf, numberOfTopElves);
            elvesWithTotalCalories.put(currentElf, caloriesOfCurrentElf);
        }
        return getTopElves(elvesWithTotalCalories, maxCalories);
    }

    private static void fillMaxCaloriesList(List<Integer> maxCalories, int caloriesOfCurrentElf, int numberOfTopElves) {
        if (maxCalories.size() < numberOfTopElves) {
            maxCalories.add(caloriesOfCurrentElf);
            Collections.sort(maxCalories);
        } else if (maxCalories.get(0) < caloriesOfCurrentElf) {
            maxCalories.remove(0);
            maxCalories.add(caloriesOfCurrentElf);
            Collections.sort(maxCalories);
        }
    }

    private static Map<Integer, Integer> getTopElves(Map<Integer, Integer> elvesWithTotalCalories,
            List<Integer> maxCalories) {
        Map<Integer, Integer> topElves = new HashMap<>();
        for (Integer currentElf : elvesWithTotalCalories.keySet()) {
            Integer caloriesOfCurrentElf = elvesWithTotalCalories.get(currentElf);
            if (maxCalories.contains(caloriesOfCurrentElf)) {
                topElves.put(currentElf, caloriesOfCurrentElf);
            }
            if (topElves.size() == maxCalories.size()) {
                break;
            }
        }
        return topElves;
    }

}
