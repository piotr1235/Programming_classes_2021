package kdruc.lesson11;

import java.rmi.UnexpectedException;

public class Dolphin extends Animal {
  public Dolphin() {
    this.commonName = "dolphin";
    this.numberOfLegs = 0;
    this.isMammal = true;
  }

  @Override
  public void makeSound() {
    System.out.println("eeeeeee");
  }
}
