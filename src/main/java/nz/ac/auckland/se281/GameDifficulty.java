package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class GameDifficulty {

  /**
   * Create AI instances based on the difficulty level given by the player.
   *
   * @param difficulty Enum of the difficulty level (EASY, MEDIUM or HARD) of the AI set by Player.
   * @param playerChoice Enum of the choice (EVEN or ODD) set by Player.
   * @param history List of Choices (EVEN or ODD) representing the history of the player's choices.
   * @param roundNumber Integer representing the current round number.
   * @param nextStrategy String representing the next strategy to be used by the AI.
   * @return AiTurn object representing the AI instance created.
   */
  public static AiTurn setDifficulty(
      Difficulty difficulty,
      Choice playerChoice,
      List<Choice> history,
      int roundNumber,
      String nextStrategy) {

    switch (difficulty) {
      case EASY:
        return new EasyAi();

      case MEDIUM:
        return new MediumAi(playerChoice, history, roundNumber);

      case HARD:
        return new HardAi(playerChoice, history, roundNumber, nextStrategy);
    }
    return null;
  }
}
