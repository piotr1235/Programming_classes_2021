package kdruc.crypto;

import java.security.PublicKey;

public class Transaction implements ITransaction {
  final private PublicKey accountFrom;
  final private PublicKey accountTo;
  final private int amount;

  public Transaction(PublicKey accountFrom, PublicKey accountTo, int amount) {
    this.accountFrom = accountFrom;
    this.accountTo = accountTo;
    this.amount = amount;
  }

  public Transaction(Transaction transaction) {
    this.accountFrom = transaction.accountFrom;
    this.accountTo = transaction.accountTo;
    this.amount = transaction.amount;
  }

  @Override
  public String toString() {
    String shortAccountFrom = Utils.getShortKey(accountFrom);
    String shortAccountTo = Utils.getShortKey(accountTo);

    return String.format("amount: %6d, from: %s, to: %s", amount, shortAccountFrom, shortAccountTo);
  }

  @Override
  public void addInput(TransactionInput transactionInput) {
    return;
  }

  @Override
  public void addOutput(TransactionOutput transactionOutput) {
    return;
  }

  public PublicKey getAccountFrom() {
    return accountFrom;
  }

  public PublicKey getAccountTo() {
    return accountTo;
  }

  public int getAmount() {
    return amount;
  }
}
