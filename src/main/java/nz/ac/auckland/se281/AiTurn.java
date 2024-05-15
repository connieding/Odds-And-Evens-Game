package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class AiTurn {
  private Strategy strategy;
  private List<Choice> history;
  private Choice playerChoice;

  public AiTurn(Strategy strategy, Choice choice, List<Choice> history) {
    this.strategy = strategy;
    this.history = history;
    this.playerChoice = choice;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public int playFingers(int roundNumber) {
    if (3 < roundNumber && strategy instanceof TopStrategy) {
      setStrategy(new TopStrategy(playerChoice, history));
    } else {
      setStrategy(new RandomStrategy());
    }

    return strategy.aiStrategy();
  }
}
