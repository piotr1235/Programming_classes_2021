package kdruc.lesson7;

import kdruc.lesson9.Person;

import java.util.List;

public class Teacher extends Person {

  public boolean isInSchool;
  public List<String> classes;

  public Teacher(String name) {
    this.name = name;
    this.id = idCount++;
  }


  public void comeToSchool() { // encapsulation - creating function with hidden functionality
    isInSchool = true;
    System.out.printf("The teacher %s has just arrived to the school.%n", name);
  }

  public void sing() { // override
    System.out.println("oooooooooooooooooo");
  }

  public void leaveSchool() {
    isInSchool = false;
  }
}