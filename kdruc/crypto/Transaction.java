package kdruc.crypto;

import java.security.PublicKey;

public class Transaction {
  final private PublicKey accountFrom;
  final private PublicKey accountTo;
  final private int amount;

  public Transaction(PublicKey accountFrom, PublicKey accountTo, int amount) {
    this.accountFrom = accountFrom;
    this.accountTo = accountTo;
    this.amount = amount;
  }

  @Override
  public String toString() {
    String shortAccountFrom = Utils.getShortKey(accountFrom);
    String shortAccountTo = Utils.getShortKey(accountTo);

    return String.format("amount: %6d, from: %s, to: %s", amount, shortAccountFrom, shortAccountTo);
  }

}
