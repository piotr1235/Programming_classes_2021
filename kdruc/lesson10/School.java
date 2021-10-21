package kdruc.lesson10;

public class School {

  public void printStudent(Student p) {
    System.out.println(p.getName());
  }

  public void printPerson(Person p) {
    System.out.println(p.getName());
  }

  public static void main(String[] args) {
    Person piotr = new Person();
    Student tom = new Student();
    Person ben = new Student(); // SUBSTITUTION PRINCIPLE

    piotr.setName("piotr");
    tom.setName("Tom");
    ben.setName("Ben");

    School school = new School();

    school.printStudent((Student) piotr); // when we try to use superclass (parent) we need to cast
    school.printPerson(piotr); // piotr is of type Person which is accepted by this function

    school.printStudent(tom); // tom is a Student, and function accepts Students
    school.printPerson(tom); // tom is a Student and function accepts Persons - SUBSTITUTION PRINCIPLE

    // Substitution principle
    // You can use a class anywhere you use superclass -> you can use Student whenever Person is required

    System.out.println(ben.getClass());

  }
}
