package kdruc.lesson11;

public class Cat extends Animal {
  public Cat() {
    super(); // not essential
    this.commonName = "cat";
    this.numberOfLegs = 4;
    this.isMammal = true;
  }

  @Override
  public void makeSound() { //override
    System.out.println("miał");
  }

  public void purr() {
    System.out.println("mrrrrrrrr");
  }
}
