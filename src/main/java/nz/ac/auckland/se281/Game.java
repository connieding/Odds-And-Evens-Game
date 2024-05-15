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
  String playerName;
  Strategy strategy;
  AiTurn aiTurn;
  Choice choice;
  List<Choice> history = new ArrayList<>();

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);

    playerName = options[0]; // set player name
    roundNumber = 1; // reset round
    this.choice = choice;

    strategy = GameDifficulty.setDifficulty(difficulty);
  }

  public void play() {
    MessageCli.START_ROUND.printMessage(Integer.toString(roundNumber));

    while (true) {
      MessageCli.ASK_INPUT.printMessage();
      String input = Utils.scanner.nextLine();

      if (Utils.isInteger(input) && 0 <= Integer.parseInt(input) && Integer.parseInt(input) <= 5) {

        // Player move
        playerFingers = Integer.parseInt(input);
        MessageCli.PRINT_INFO_HAND.printMessage(playerName, input);

        // Ai move
        aiTurn = new AiTurn(strategy, choice, history);
        aiFingers = aiTurn.playFingers(roundNumber);
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
          if (choice == Choice.EVEN) {
            MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), "EVEN", playerName);

          } else {
            MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), "EVEN", "HAL-9000");
          }
        } else {
          if (choice == Choice.ODD) {
            MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), "ODD", playerName);

          } else {
            MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), "ODD", "HAL-9000");
          }
        }

        roundNumber++;
        break;
      }

      MessageCli.INVALID_INPUT.printMessage();
    }
  }

  public void endGame() {}

  public void showStats() {}
}
