package calorie_counting;

import java.util.Collection;
import java.util.Map;

import org.javatuples.Pair;

public class App {
    public static void main(String[] args) {
        System.out.println("\n--- Advent of Code 2022 - Day 1: Calorie Counting ---\n");
        Map<Integer, Collection<Integer>> elves = 
            CalorieInputSplitter.getElvesWithCalories("calories.txt");
        Pair<Integer, Integer> topElf = CalorieCounter.getElfWithMostCalories(elves);
        System.out.println(String.format("\"Top Elf\" %s carries %s calories\n", 
            topElf.getValue0(), topElf.getValue1()));
    }

}
