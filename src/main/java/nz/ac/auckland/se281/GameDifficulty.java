package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class GameDifficulty {

  public static Strategy setDifficulty(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        return new RandomStrategy();

      default:
        break;
    }
    return null;
  }
}
