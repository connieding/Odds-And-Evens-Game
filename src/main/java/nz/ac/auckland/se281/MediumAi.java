package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class MediumAi implements AiTurn {
  private Choice playerChoice;
  private List<Choice> history;
  private int roundNumber;
  private Strategy strategy;

  public MediumAi(Choice choice, List<Choice> history, int roundNumber) {
    playerChoice = choice;
    this.history = history;
    this.roundNumber = roundNumber;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  @Override
  public int playFingers() {
    if (3 < roundNumber) {
      setStrategy(new TopStrategy(playerChoice, history));
    } else {
      setStrategy(new RandomStrategy());
    }

    return strategy.aiStrategy();
  }
}
