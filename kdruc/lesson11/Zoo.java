package kdruc.lesson11;

import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Zoo {

  static void printInfo(Animal a) {
    System.out.printf("%s %d %b\n", a.commonName, a.numberOfLegs, a.isMammal);
  }

  public static void main(String[] args) throws UnexpectedException {
//    Animal dolphin = new Dolphin(); // abstract class cannot be created
//    Cat cat = new Cat();
//    printInfo(cat);
//    // printInfo(panda);
//    dolphin.makeSound();
//    cat.makeSound();
//    cat.purr();

    Animal a1 = new Dolphin();
    Animal a2 = new Cat();
    Cat a3 = new Cat();

    // if a variable is of a certain type, then it has access only to fields/methods from that class

    a1.makeSound();
    a2.makeSound();
    a3.makeSound();

    printInfo(a1);
    printInfo(a2);
    printInfo(a3);

    a3.purr();

    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new LinkedList<>();
  }
}

// Upon exception
// 1. Try/catch clause
// 2. Add to class/method signature (throws Exception)

// abstract class says WHAT to do, and specific implementation says HOW to do it
