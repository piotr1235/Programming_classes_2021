package kdruc.crypto;

import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.Arrays;

public class TransactionInput {
    private String previousTransactionHash;
    private int index;
    private byte[] signature;
    private PublicKey publicKey;

    public TransactionInput(String previousTransactionHash, int index, byte[] signature, PublicKey publicKey){
        this.previousTransactionHash = previousTransactionHash;
        this.index = index;
        this.signature = signature;
        this.publicKey = publicKey;
    }

    @Override
    public String toString() {
        return "Input:" + '\n' +
                "Previous tx:" + previousTransactionHash + '\n' +
                "Index:" + index + '\n' +
                "scriptSig:" + Arrays.toString(signature) + '\n' +
                " " + Utils.getShortKey(publicKey);
    }

}
