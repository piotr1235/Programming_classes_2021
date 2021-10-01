package kdruc.lesson7;

import java.util.List;

public class Teacher {
  public String name;
  public int age;
  public String id;
  public boolean isInSchool;
  public List<String> classes;

  public void comeToSchool() { // encapsulation - creating function with hidden functionality
    isInSchool = true;
    System.out.printf("The teacher %s has just arrived to the school.%n", name);
  }

  public void leaveSchool() {
    isInSchool = false;
  }
}
