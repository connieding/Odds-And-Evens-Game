package nz.ac.auckland.se281;

public class AiTurn {
  private Strategy strategy;

  public AiTurn(Strategy strategy) {
    this.strategy = strategy;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public int playFingers() {
    return strategy.aiStrategy();
  }
}
