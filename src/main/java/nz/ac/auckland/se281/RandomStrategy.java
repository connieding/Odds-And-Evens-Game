package nz.ac.auckland.se281;

/** Random Strategy class. */
public class RandomStrategy implements Strategy {

  /**
   * This method for AI strategy, Random Strategy, generate a random number of fingers for the AI
   * between 0 and 5 inclusive.
   *
   * @return int representing the number of fingers between 0 and 5 inclusive played by the AI.
   */
  @Override
  public int aiStrategy() {
    int aiFingers = Utils.getRandomNumberRange(0, 5);
    return aiFingers;
  }
}
