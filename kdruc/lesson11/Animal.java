
package kdruc.lesson11;

import java.rmi.UnexpectedException;

public abstract class Animal {

  String commonName = "animal";
  int numberOfLegs = 0;
  boolean isMammal = false;

  public Animal() {
    System.out.println("New animal!");
  }

  public void makeSound() throws UnexpectedException { // signature of a method
    throw new UnexpectedException("Cannot make sound");
  }
}