package supply_stacks;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import supply_stacks.CargoOperation.MoveOperation;

class CargoOperationInputParserTest {

  @Test
  public void parseCargoOpsInputIntoListOfMoveOperations() {
    // GIVEN
    String resource = "cargo-rearrange-ops.txt";
    // WHEN
    List<MoveOperation> moveOperations = CargoOperationInputParser.parse(resource);
    // THEN
    Assertions.assertThat(moveOperations).hasSize(3);
    Assertions.assertThat(moveOperations.get(0)).isEqualTo(new MoveOperation(2, 8, 1));
  }
}