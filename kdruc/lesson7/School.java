package kdruc.lesson7;

public class School {
  public static void main(String[] args) {
    Student student1 = new Student("Adam");
    Student student2 = new Student("Piotr");
    Student student3 = new Student("Tom");
    Student student4 = new Student("Kuba");

    student1.printInfo();
    student2.printInfo();
    student3.printInfo();
    student4.printInfo();

    System.out.println("---------------------");

    student1.receiveGrade(1.2);
    student1.receiveGrade(6);
    student1.receiveGrade(3.3);
    student1.receiveGrade(4.5);
    student1.sing();
  }
}
