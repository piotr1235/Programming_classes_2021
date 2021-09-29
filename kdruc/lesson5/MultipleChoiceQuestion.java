package kdruc.lesson5;

import java.util.ArrayList;
import java.util.List;

public class MultipleChoiceQuestion {
  final private String question;
  final private List<String> choices;
  final private int correct;

  public MultipleChoiceQuestion(String question, List<String> choices, int correct) {
    this.question = question;
    this.choices = new ArrayList<>(choices);
    this.correct = correct;
  }


  public void ask() {
    System.out.println(this.question);
    int i = 1;
    for (String choice : choices) {
      System.out.printf("%d) %s%n", i, choice);
      i++;
    }
  }

  public boolean check(String userAnswer) {
    int userAnswerInt = Integer.parseInt(userAnswer);
    return this.correct == userAnswerInt;
  }


}
