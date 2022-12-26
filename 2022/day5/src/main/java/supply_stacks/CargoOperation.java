package supply_stacks;

public class CargoOperation {

  static class MoveOperation {
    final int numberOfCrates;
    final int from;
    final int to;

    public MoveOperation(int numberOfCrates, int from, int to) {
      this.numberOfCrates = numberOfCrates;
      this.from = from;
      this.to = to;
    }

    @Override
    public boolean equals(Object obj) {
      return obj instanceof MoveOperation
          && this.numberOfCrates == ((MoveOperation) obj).numberOfCrates
          && this.from == ((MoveOperation) obj).from
          && this.to == ((MoveOperation) obj).to;
    }
  }

}
