package kdruc.crypto;

import java.security.PublicKey;

public interface ITransaction {
    @Override
    public String toString();
    public void addInput(TransactionInput transactionInput);
    public void addOutput(TransactionOutput transactionOutput);
}
