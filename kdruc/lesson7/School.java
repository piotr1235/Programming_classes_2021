package kdruc.lesson7;

public class School {
  public static void main(String[] args) {
    Student student1 = new Student("Adam");
    Student student2 = new Student("Piotr");
    Student student3 = new Student("Tom");
    Student student4 = new Student("Kuba");

    Teacher teacher1 = new Teacher("wiktor");
    Teacher teacher2 = new Teacher("lech");
    Teacher teacher3 = new Teacher("Ben");
    Teacher teacher4 = new Teacher("Mr White");

    student1.printInfo();
    student2.printInfo();
    student3.printInfo();
    student4.printInfo();

    teacher1.printInfo();
    teacher2.printInfo();
    teacher3.printInfo();
    teacher4.printInfo();

    System.out.println("---------------------");

    student1.receiveGrade(1.2);
    student1.receiveGrade(6);
    student1.receiveGrade(3.3);
    student1.receiveGrade(4.5);


    student1.sing();
    teacher2.sing();
  }
}
