package tree_house;

public class App {

  public static void main(String[] args) {
    System.out.println("\n--- Advent of Code 2022 - Day 8: Treetop Tree House ---\n");
    Forest forest = ForestParser.parse("forest.txt");
    System.out.println(String.format("All visible trees: %s", forest.getAllVisibleTrees()));
  }
}
