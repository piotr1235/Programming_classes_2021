package kdruc.crypto;

import java.util.LinkedList;
import java.util.List;

public class UTXO {
    private List<TransactionInput> inputList;
    private List<TransactionOutput> outputList;

    public void addInput(TransactionInput transactionInput){
        if(this.inputList == null) this.inputList = new LinkedList<>();
        inputList.add(transactionInput);
    }
    public void addOutput(TransactionOutput transactionOutput){
        if(this.outputList == null) this.outputList = new LinkedList<>();
        outputList.add(transactionOutput);
    }
    public int getInCounter(){
      return inputList.size();
    }

    public int getOutCounter(){
        return outputList.size();
    }

    public List<TransactionOutput> getOutputList() {
        return outputList;
    }

    @Override
    public String toString() {
        return "UTXO{" +
                "inputList=" + inputList +
                ", outputList=" + outputList +
                '}';
    }
    //list of inputs list<>
    //list of outputs list<>
}
