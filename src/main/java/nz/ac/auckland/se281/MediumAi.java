package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/** Medium AI Class. */
public class MediumAi implements AiTurn {
  private Choice playerChoice;
  private List<Choice> history;
  private int roundNumber;
  private Strategy strategy;

  /**
   * Constructor for the Medium level Ai which sets the player's choice, history and round number.
   *
   * @param choice Choice object representing the choice (EVEN or ODD) set by the player.
   * @param history List of Choices (EVEN or ODD) representing the history of the player's choices.
   * @param roundNumber Integer representing the current round number.
   */
  public MediumAi(Choice choice, List<Choice> history, int roundNumber) {
    playerChoice = choice;
    this.history = history;
    this.roundNumber = roundNumber;
  }

  /**
   * Set the strategy for the Medium Level Ai.
   *
   * @param strategy Strategy object representing the strategy (Top or Random) to be used by the Ai.
   */
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  /**
   * Play fingers based on the AI strategy of the Medium Level Ai.
   *
   * @return int representing the number of fingers between 0 nd 5 inclusive played by the Medium
   *     Level Ai.
   */
  @Override
  public int playFingers() {
    // If the round number is less than or equal to 3, the AI will use the Random strategy.
    if (3 < roundNumber) {
      setStrategy(new TopStrategy(playerChoice, history));
    } else {
      setStrategy(new RandomStrategy());
    }

    return strategy.aiStrategy();
  }
}
