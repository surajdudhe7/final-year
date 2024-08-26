package com.codiebyheart.cryptography;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private String transactionId;
    private PublicKey sender;
    private PublicKey receiver;
    private double amount;

    private byte[] signatureValue;
    public List<TransactionsInput> inputs;
    public List<TransactionsOutput> outputs;

    public Transaction(PublicKey sender, PublicKey receiver, double amount, List<TransactionsInput> inputs) {
        this.inputs = new ArrayList<TransactionsInput>();
        this.outputs = new ArrayList<TransactionsOutput>();
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.inputs = inputs;
        calculateHash();

    }

    private  void  calculateHash(){

        this.transactionId = CryptoAlgorithm.generateHash(sender.toString() + receiver.toString()+ Double.toString(amount));

    }

    public void generateSignature(PrivateKey privateKey){
        signatureValue = CryptoAlgorithm.ECDSAsiganture(privateKey,sender.toString() + receiver.toString() + Double.toString(amount));

    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public PublicKey getSender() {
        return sender;
    }

    public void setSender(PublicKey sender) {
        this.sender = sender;
    }

    public PublicKey getReceiver() {
        return receiver;
    }

    public void setReceiver(PublicKey receiver) {
        this.receiver = receiver;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public byte[] getSignatureValue() {
        return signatureValue;
    }

    public void setSignatureValue(byte[] signatureValue) {
        this.signatureValue = signatureValue;
    }

    public List<TransactionsInput> getInputs() {
        return inputs;
    }

    public void setInputs(List<TransactionsInput> inputs) {
        this.inputs = inputs;
    }

    public List<TransactionsOutput> getOutputs() {
        return outputs;
    }

    public void setOutputs(List<TransactionsOutput> outputs) {
        this.outputs = outputs;
    }
}
