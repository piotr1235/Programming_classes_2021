package kdruc.lesson4;


import kdruc.lesson5.MultipleChoiceQuestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {

  public static void run() {
    Question question1 = new Question("How much is 2+2?", "four");
    Question question2 = new Question("How much is from Warsaw to Szczecin?", "500km");

    List<Question> questionList = new ArrayList<>(List.of(question1, question2));

    MultipleChoiceQuestion multi1 = new MultipleChoiceQuestion("Which number is greater than 5?", new ArrayList<>(List.of("1", "2", "6")), 3);
    MultipleChoiceQuestion multi2 = new MultipleChoiceQuestion("Which number is greater than 5?", new ArrayList<>(List.of("1", "6", "2")), 2);

    List<MultipleChoiceQuestion> multipleChoiceQuestionList = new ArrayList<>(List.of(multi1, multi2));

    final Scanner in = new Scanner(System.in); // read only

    int correctCount = 0;
    int allQuestions = questionList.size() + multipleChoiceQuestionList.size();

    for (Question question : questionList) {
      question.ask();
      String userAnswer = in.nextLine();
      boolean isCorrect = question.check(userAnswer);
      if (isCorrect) {
        correctCount++;
      }
    }

    for (MultipleChoiceQuestion multipleQuestion : multipleChoiceQuestionList) {
      multipleQuestion.ask();
      String userAnswer = in.nextLine();
      boolean isCorrect = multipleQuestion.check(userAnswer);
      if (isCorrect) {
        correctCount++;
      }

    }

    System.out.printf("You got %d correct answers out of %d", correctCount, allQuestions);

  }

  public static void main(String[] args) {
    run();
  }
}
