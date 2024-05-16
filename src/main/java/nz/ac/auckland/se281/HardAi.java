package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/** Hard AI class */
public class HardAi implements AiTurn {
  private Choice playerChoice;
  private List<Choice> history;
  private int roundNumber;
  private String nextStrategy;
  private Strategy strategy;

  /**
   * Constructor for the Hard level Ai which sets the player's choice, history, round number and
   * next strategy.
   *
   * @param choice Choice object representing the choice (EVEN or ODD) set by the player.
   * @param history List of Choices (EVEN or ODD) representing the history of the player's choices.
   * @param roundNumber Integer representing the current round number.
   * @param nextStrategy String representing the next strategy to be used by the AI.
   */
  public HardAi(Choice choice, List<Choice> history, int roundNumber, String nextStrategy) {
    playerChoice = choice;
    this.history = history;
    this.roundNumber = roundNumber;
    this.nextStrategy = nextStrategy;
  }

  /**
   * Set the strategy for the Hard Level Ai.
   *
   * @param strategy Strategy object representing the strategy (Top or Random) to be used by the AI.
   */
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  /**
   * Play fingers based on the AI strategy of the Hard Level Ai.
   *
   * @return int representing the number of fingers played by the Hard Level Ai.
   */
  @Override
  public int playFingers() {

    // If the round number is less than or equal to 3, the AI will use the Random strategy.
    if (roundNumber <= 3) {
      setStrategy(new RandomStrategy());
    }

    // If the round number is greater than 3, the AI will switch to the next strategy.
    if (3 < roundNumber) {
      if (nextStrategy.equals("Random")) {
        setStrategy(new RandomStrategy());
      } else {
        setStrategy(new TopStrategy(playerChoice, history));
      }
    }

    return strategy.aiStrategy();
  }
}
