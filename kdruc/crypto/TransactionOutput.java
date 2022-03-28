package kdruc.crypto;

public class TransactionOutput {
    private int value;
    private String publicKeyHash;

    public TransactionOutput(int value, String publicKeyHash){
        this.value = value;
        this.publicKeyHash= publicKeyHash;
    }

    public String getPublicKeyHash() {
        return publicKeyHash;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Output:" + '\n' +
                "Value:" + value +'\n'+
                "publicKeyHash:'" + publicKeyHash;
    }
}
