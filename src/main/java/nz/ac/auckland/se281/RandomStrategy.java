package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy {

  @Override
  public int aiStrategy() {
    int aiFingers = Utils.getRandomNumberRange(0, 5);
    return aiFingers;
  }
}
