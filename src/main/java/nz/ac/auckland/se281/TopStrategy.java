package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/** Top Strategy class. */
public class TopStrategy implements Strategy {
  private List<Choice> history;
  private Choice aiChoice;

  /**
   * Constructor for TopStrategy class which sets the player's choice and history.
   *
   * @param playerChoice Enum of the choice (EVEN or ODD) set by Player.
   * @param history list of choices (EVEN or ODD) representing the history of the player's choices.
   */
  public TopStrategy(Choice playerChoice, List<Choice> history) {
    this.history = history;

    if (playerChoice == Choice.EVEN) {
      aiChoice = Choice.ODD;
    } else {
      aiChoice = Choice.EVEN;
    }
  }

  /**
   * This method for AI strategy, Top Strategy, monitors how frequently the player has input even
   * and odd numbers. Based on this data, the strategy predicts what the player will likely continue
   * favoring based on the most frequently chosen type of number (ODD or EVEN) and adapts its own
   * approach accordingly.
   *
   * @return int representing the number of fingers between 0 and 5 inclusive played by the AI.
   */
  @Override
  public int aiStrategy() {
    int evenTimes = 0;
    int oddTimes = 0;

    // Count how many times the player has chosen even and odd numbers.
    for (Choice type : history) {
      if (type == Choice.EVEN) {
        evenTimes++;
      } else {
        oddTimes++;
      }
    }

    // If the player has chosen even numbers more frequently than odd numbers.
    if (evenTimes > oddTimes) {
      if (aiChoice == Choice.EVEN) {
        // ai need even number (even + even = even).
        return Utils.getRandomEvenNumber();

      } else {
        // ai need odd number (even + odd = odd).
        return Utils.getRandomOddNumber();
      }
    }

    // If the player has chosen odd numbers more frequently than even numbers.
    if (evenTimes < oddTimes) {
      if (aiChoice == Choice.EVEN) {
        // ai need odd number (odd + odd = even).
        return Utils.getRandomOddNumber();

      } else {
        // ai need even number (odd + even = odd).
        return Utils.getRandomEvenNumber();
      }
    }

    // If the player has chosen even and odd numbers equally, returns a random number between 0 and
    // 5 inclusive.
    return Utils.getRandomNumberRange(0, 5);
  }
}
