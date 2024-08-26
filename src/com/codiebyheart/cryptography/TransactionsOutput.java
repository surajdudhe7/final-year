package com.codiebyheart.cryptography;

import java.security.PublicKey;

public class TransactionsOutput {
    private String id;
    private String parentKey;//parent transaction id
    private PublicKey receiver;
    private double amount;

    public TransactionsOutput(PublicKey receiver, double amount, String parentKey) {
        this.parentKey = parentKey;
        this.receiver = receiver;
        this.amount = amount;
        generateId();
    }

    public void generateId(){
        this.id = CryptoAlgorithm.generateHash(receiver.toString()+ Double.toString(amount) + parentKey);
    }

    public boolean isMine(PublicKey publicKey){
        return publicKey == receiver;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentKey() {
        return parentKey;
    }

    public void setParentKey(String parentKey) {
        this.parentKey = parentKey;
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
}
