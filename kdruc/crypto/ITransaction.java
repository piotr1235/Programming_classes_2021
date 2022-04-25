package kdruc.crypto;

public interface ITransaction {
  @Override
  public String toString();

  public void addInput(TransactionInput transactionInput);

  public void addOutput(TransactionOutput transactionOutput);
}
