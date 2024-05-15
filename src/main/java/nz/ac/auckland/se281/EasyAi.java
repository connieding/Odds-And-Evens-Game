package nz.ac.auckland.se281;

public class EasyAi implements AiTurn {
  private Strategy strategy;

  public EasyAi() {
    setStrategy(new RandomStrategy());
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  @Override
  public int playFingers() {
    return strategy.aiStrategy();
  }
}
