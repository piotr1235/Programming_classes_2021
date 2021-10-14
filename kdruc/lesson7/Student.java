package kdruc.lesson7;

import kdruc.lesson9.Person;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

  public String className;
  public double average;
  public List<Double> grades = new ArrayList<>();

  public Student(String name) {
    this.name = name;
    this.id = idCount++;
  }

  public void receiveGrade(double grade) {
    grades.add(grade);
    this.calculateAverage();
  }

  public void calculateAverage() {
    int size = grades.size();
    double sum = 0;
    for (int i = 0; i < size; i++) {
      sum += grades.get(i);
    }
    this.average = sum / size;
  }

  public void sing() {
    System.out.println("LALALA");
  }

  public void printInfo() {
    System.out.printf("%8s %-4s avg=%f%n", name, id, average);
  }
}
