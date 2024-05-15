package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class TopStrategy implements Strategy {
  List<Choice> history;
  Choice aiChoice;

  public TopStrategy(Choice playerChoice, List<Choice> history) {
    this.history = history;

    if (playerChoice == Choice.EVEN) {
      aiChoice = Choice.ODD;
    } else {
      aiChoice = Choice.EVEN;
    }
  }

  @Override
  public int aiStrategy() {
    int evenTimes = 0;
    int oddTimes = 0;

    for (Choice type : history) {
      if (type == Choice.EVEN) {
        evenTimes++;
      } else {
        oddTimes++;
      }
    }

    if (evenTimes > oddTimes) {
      if (aiChoice == Choice.EVEN) {
        // ai need even number (even + even = even)
        return Utils.getRandomEvenNumber();

      } else {
        // ai need odd number (even + odd = odd)
        return Utils.getRandomOddNumber();
      }
    }

    if (evenTimes < oddTimes) {
      if (aiChoice == Choice.EVEN) {
        // ai need odd number (odd + odd = even)
        return Utils.getRandomOddNumber();

      } else {
        // ai need even number (odd + even = odd)
        return Utils.getRandomEvenNumber();
      }
    }

    // return Utils.getRandomEvenNumber();
    return Utils.getRandomNumberRange(0, 5);
  }
}
