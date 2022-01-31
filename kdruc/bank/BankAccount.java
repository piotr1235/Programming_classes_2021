package kdruc.bank;

public class BankAccount {
  private int balance;
  private int accountId;

  public BankAccount(int balance, int accountId) {
    this.balance = balance;
    this.accountId = accountId;
  }

  public int getAccountId() {
    return accountId;
  }

  public int getBalance() {
    return balance;
  }

  public void transferTo(BankAccount accTo, int amount) {
    this.balance -= amount;
    accTo.balance += amount;
  }

  @Override
  public String toString() {
    return String.format("Balance: %6d, Account ID: %6d", balance, accountId);
  }
}
