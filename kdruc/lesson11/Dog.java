package kdruc.lesson11;

import java.rmi.UnexpectedException;

public class Dog extends Animal { // you must implement all abstract methods

  // override changes the old one to the new one
  // implements add new one (no old one)

  @Override
  public void makeSound() throws UnexpectedException {
    System.out.println("Hał Hał");
  }
}
