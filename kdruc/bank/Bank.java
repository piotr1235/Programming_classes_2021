package kdruc.bank;


import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Bank {

  private List<BankAccount> accounts;
  private final Random randGen = new Random();

  public void printAccounts() {
    for (BankAccount bankAccount : accounts) {
      System.out.println(bankAccount);
    }
    System.out.println(bankBalance());
  }

  public int bankBalance() {
    int sum = 0;
    for (BankAccount bankAccount : accounts) {
      sum += bankAccount.getBalance();
    }
    return sum;
  }

  public void generateAccounts(int n, int balance) {
    accounts = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
      accounts.add(new BankAccount(i, balance));
    }
  }

  public void simulateRandTransactions(int n, int balance) {
    for (int i = 0; i < n; i++) {
      int id1 = randGen.nextInt(accounts.size());
      int id2 = randGen.nextInt(accounts.size());
      int amount = randGen.nextInt(balance);

      BankAccount bankAccountFrom = accounts.get(id1);
      BankAccount bankAccountTo = accounts.get(id2);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      bankAccountFrom.transferTo(bankAccountTo, amount);
      System.out.println(bankBalance());
    }
  }

  public void simulateParallel(int n) {
    List<Thread> threads = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      Thread thread = new Thread() {
        public void run() {
          simulateRandTransactions(10, 500);
        }
      };
      threads.add(thread);
    }

    for (Thread thread : threads) {
      thread.start();
    }
  }

  public static void main(String[] args) {
    Bank bank = new Bank();
    bank.generateAccounts(3, 1000);
    System.out.println(bank.bankBalance());
    bank.simulateParallel(10);
    System.out.println(bank.bankBalance());
  }
}
