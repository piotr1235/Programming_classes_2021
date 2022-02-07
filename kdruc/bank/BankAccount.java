package kdruc.bank;

public class BankAccount {
  private int accountId;
  private int balance;

  public BankAccount(int accountId, int balance) {
    this.accountId = accountId;
    this.balance = balance;
  }

  public int getAccountId() {
    return accountId;
  }

  public int getBalance() {
    return balance;
  }

  public void transferTo(BankAccount accTo, int amount) {

    BankAccount first = this, second = accTo;

    if (this.accountId > accTo.accountId) {
      first = accTo;
      second = this;
    }

    synchronized (first) {
      synchronized (second) {
        this.balance = this.balance - amount;
        accTo.balance += amount;
      }
    }
  }

  @Override
  public String toString() {
    return String.format("Account ID: %6d, Balance: %6d", accountId, balance);
  }
}
