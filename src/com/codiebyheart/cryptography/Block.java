package com.codiebyheart.cryptography;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Block {
    private int id;
    private int nonce;
    private String hash;
    private String previousHash;
    private long timestamp;
    public List<Transaction> transactionList;

    public Block(String previousHash) {
        this.transactionList = new ArrayList<>();
        this.previousHash = previousHash;
        this.timestamp = new Date().getTime();
        generateHash();
    }
    public void generateHash(){
        this.hash = CryptoAlgorithm.generateHash(Integer.toString(id)+previousHash+Long.toString(timestamp)+transactionList.toString()+Integer.toString(nonce));

    }
    public void increaseNonce(){this.nonce++;}
    public String getHash(){return this.hash;}

    public boolean addTransaction(Transaction transaction){
        if(transaction == null) return false;
        if(!previousHash.equals(Constants.GENESIS_PREV_HASH)){
            return false;
        }
        return true;
    }
}
