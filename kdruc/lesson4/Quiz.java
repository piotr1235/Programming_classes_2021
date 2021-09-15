package kdruc.lesson4;

import java.util.ArrayList;
import java.util.List;

public class Quiz {

  public static void run() {
    Question question1 = new Question("How much is 2+2?", "four");
    Question question2 = new Question("How much is from Warsaw to Szczecin?", "500km");

    List<Question> questionList = new ArrayList<>(List.of(question1, question2));

    for (Question question : questionList) {
      question.ask();
    }

  }

  public static void main(String[] args) {
    run();
  }
}
