package kdruc.bank;


import java.util.LinkedList;
import java.util.List;

public class Bank {

  List<BankAccount> accounts;

  public void printAccounts() {
    for (BankAccount bankAccount : accounts) {
      System.out.println(bankAccount);
    }
  }

  public static void main(String[] args) {
    Bank bank = new Bank();

    BankAccount s1 = new BankAccount(200, 1);
    BankAccount s2 = new BankAccount(1000, 2);
    bank.accounts = new LinkedList<>(List.of(s1, s2));

    bank.printAccounts();
    s1.transferTo(s2, 400);
    bank.printAccounts();
  }
}
