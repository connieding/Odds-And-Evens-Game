package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class GameDifficulty {

  public static AiTurn setDifficulty(
      Difficulty difficulty, Choice playerChoice, List<Choice> history, int roundNumber) {
    switch (difficulty) {
      case EASY:
        return new EasyAi();

      case MEDIUM:
        return new MediumAi(playerChoice, history, roundNumber);

      case HARD:
        return new HardAi(playerChoice, history, roundNumber);
    }
    return null;
  }
}
