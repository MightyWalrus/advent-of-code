package rucksack_reorg;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class CommonItemsFinder {

  static Collection<Character> findCommon(Collection<Collection<Character>> compartments) {
    return compartments.stream()
        .reduce((common, compartment) -> common.stream()
            .filter(compartment::contains)
            .distinct()
            .collect(Collectors.toList()))
        .orElse(Collections.emptyList());
  }

}
