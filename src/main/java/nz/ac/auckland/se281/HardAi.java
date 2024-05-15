package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class HardAi implements AiTurn {
  Choice playerChoice;
  List<Choice> history;
  int roundNumber;
  String previousWinner;
  String nextStrategy;
  private Strategy strategy;

  public HardAi(
      Choice choice,
      List<Choice> history,
      int roundNumber,
      String previousWinner,
      String nextStrategy) {
    playerChoice = choice;
    this.history = history;
    this.roundNumber = roundNumber;
    this.previousWinner = previousWinner;
    this.nextStrategy = nextStrategy;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  @Override
  public int playFingers() {

    if (roundNumber <= 3) {
      setStrategy(new RandomStrategy());
    }

    // if the previous winner is the player, then the AI will use different strategy
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
