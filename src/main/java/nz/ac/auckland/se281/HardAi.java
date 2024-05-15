package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class HardAi implements AiTurn {
  Choice playerChoice;
  List<Choice> history;
  int roundNumber;
  String previousWinner;
  private Strategy strategy;

  public HardAi(Choice choice, List<Choice> history, int roundNumber, String previousWinner) {
    playerChoice = choice;
    this.history = history;
    this.roundNumber = roundNumber;
    this.previousWinner = previousWinner;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  @Override
  public int playFingers() {
    setStrategy(new RandomStrategy());

    if (roundNumber == 4) {
      setStrategy(new TopStrategy(playerChoice, history));
    }

    return strategy.aiStrategy();
  }
}
