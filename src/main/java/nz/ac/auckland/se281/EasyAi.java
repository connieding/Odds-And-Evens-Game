package nz.ac.auckland.se281;

/** Easy AI class */
public class EasyAi implements AiTurn {
  private Strategy strategy;

  /** Constructor for the Easy level Ai */
  public EasyAi() {
    setStrategy(new RandomStrategy());
  }

  /**
   * Set the strategy for the Easy Level AI.
   *
   * @param strategy Strategy object representing the strategy to be used by the AI.
   */
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  /**
   * Play fingers based on the AI strategy of the Easy Level Ai.
   *
   * @return int representing the number of fingers between 0 and 5 inclusive played by the Easy
   *     Level Ai.
   */
  @Override
  public int playFingers() {
    return strategy.aiStrategy();
  }
}
