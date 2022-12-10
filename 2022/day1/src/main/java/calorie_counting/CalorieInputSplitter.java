package calorie_counting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CalorieInputSplitter {

    static Map<Integer, Collection<Integer>> getElvesWithCalories(String resourcePath) {
        Map<Integer, Collection<Integer>> map = new HashMap<>();
        try (
                InputStream is = CalorieInputSplitter.class.getClassLoader().getResourceAsStream(resourcePath);
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr)) {
            int currentElf = 1;
            String line = br.readLine();
            while (line != null) {

                if (line.isBlank()) {
                    currentElf++;
                    line = br.readLine();
                    continue;
                }

                Collection<Integer> calories = map.get(currentElf);
                if (calories == null) {
                    calories = new ArrayList<>();
                    map.put(currentElf, calories);
                }
                calories.add(Integer.valueOf(line));
                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

}
