package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  int roundNumber = 1;
  int playerFingers;
  int aiFingers;
  int playerWins = 0;
  int aiWins = 0;
  String playerName;
  String previousWinner;
  String nextStrategy;
  Boolean gameStarted = false;
  AiTurn aiTurn;
  Difficulty gameDifficulty;
  Choice playerChoice;
  List<Choice> history = new ArrayList<>();

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);

    // reset game
    history.clear();
    roundNumber = 1;
    nextStrategy = "Random";
    playerWins = 0;
    aiWins = 0;

    // set game preferences
    gameDifficulty = difficulty;
    playerName = options[0];
    playerChoice = choice;

    gameStarted = true;
  }

  public void play() {
    // Check if game has been created
    if (!gameStarted) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    MessageCli.START_ROUND.printMessage(Integer.toString(roundNumber));

    while (true) {
      MessageCli.ASK_INPUT.printMessage();
      String input = Utils.scanner.nextLine();

      if (Utils.isInteger(input) && 0 <= Integer.parseInt(input) && Integer.parseInt(input) <= 5) {

        // Player move
        playerFingers = Integer.parseInt(input);
        MessageCli.PRINT_INFO_HAND.printMessage(playerName, input);

        // Ai move
        aiTurn =
            GameDifficulty.setDifficulty(
                gameDifficulty, playerChoice, history, roundNumber, previousWinner, nextStrategy);

        aiFingers = aiTurn.playFingers();

        MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", Integer.toString(aiFingers));

        // record players choice of number
        if (Utils.isEven(playerFingers)) {
          history.add(Choice.EVEN);
        } else {
          history.add(Choice.ODD);
        }

        // check winner of the round
        int sum = playerFingers + aiFingers;
        if (Utils.isEven(sum)) {
          if (playerChoice == Choice.EVEN) {
            MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), "EVEN", playerName);
            previousWinner = playerName;
            playerWins++;

            // if the player wins previous rounds, the AI will change strategy
            if (roundNumber >= 3 && gameDifficulty == Difficulty.HARD) {
              if (nextStrategy.equals("Random")) {
                nextStrategy = "Top";
              } else {
                nextStrategy = "Random";
              }
            }

          } else {
            MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), "EVEN", "HAL-9000");
            previousWinner = "HAL-9000";
            aiWins++;
          }
        } else {
          if (playerChoice == Choice.ODD) {
            MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), "ODD", playerName);
            previousWinner = playerName;
            playerWins++;

            // if the player wins previous rounds, the AI will change strategy
            if (roundNumber >= 3 && gameDifficulty == Difficulty.HARD) {
              if (nextStrategy.equals("Random")) {
                nextStrategy = "Top";
              } else {
                nextStrategy = "Random";
              }
            }

          } else {
            MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), "ODD", "HAL-9000");
            previousWinner = "HAL-9000";
            aiWins++;
          }
        }

        roundNumber++;
        break;
      }

      MessageCli.INVALID_INPUT.printMessage();
    }
  }

  public void endGame() {
    showStats();

    if (playerWins < aiWins) {
      MessageCli.PRINT_END_GAME.printMessage("HAL-9000");
    } else if (playerWins > aiWins) {
      MessageCli.PRINT_END_GAME.printMessage(playerName);
    } else {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    }

    gameStarted = false;
  }

  public void showStats() {
    if (!gameStarted) {
      MessageCli.GAME_NOT_STARTED.printMessage();
    }

    MessageCli.PRINT_PLAYER_WINS.printMessage(
        playerName, Integer.toString(playerWins), Integer.toString(aiWins));
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        "HAL-9000", Integer.toString(aiWins), Integer.toString(playerWins));
  }
}
