package kdruc.lesson4;

public class Question {
  final private String question;
  final private String answer;

  public Question(String question, String answer) {
    this.question = question;
    this.answer = answer;
  }

  public void ask() {
    System.out.println(this.question);
  }

  public boolean check(String userAnswer) {
    return this.answer.equals(userAnswer);
  }

  @Override
  public String toString() {
    return "{" +
      "q='" + question + '\'' +
      ", a='" + answer + '\'' +
      '}';
  }
}
