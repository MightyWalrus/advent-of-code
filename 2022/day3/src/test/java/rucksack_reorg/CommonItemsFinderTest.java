package rucksack_reorg;

import java.util.Collection;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CommonItemsFinderTest {

  @Test
  public void findDistinctCommonCharactersInCollectionOfCollections() {
    // GIVEN
    Collection<Collection<Character>> compartments = List.of(
        List.of('A', 'b', 'C', 'b'), List.of('a', 'b', 'c', 'b'));
    // WHEN
    Collection<Character> commonItems = CommonItemsFinder.findCommon(compartments);
    // THEN
    Assertions.assertThat(commonItems.size()).isEqualTo(1);
    Assertions.assertThat(commonItems).containsExactly('b');
  }

}