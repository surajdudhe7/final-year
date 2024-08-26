package com.codiebyheart.cryptography;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Wallet {
    private PrivateKey privateKey;
    private PublicKey publicKey;

    public Wallet(){
        KeyPair keyPair = CryptoAlgorithm.curveCrypto();
        this.privateKey = keyPair.getPrivate();
        this.publicKey = keyPair.getPublic();

    }

    public double calculateBalance(){
        double balance = 0;
        for(Map.Entry<String , TransactionsOutput>item: BlockChain.transactionMap.entrySet()){

          TransactionsOutput transactionsOutput = item.getValue();
          if(transactionsOutput.isMine(publicKey))
              balance+=transactionsOutput.getAmount();
        }

        return balance;
    }

    public Transaction transferAmount(PublicKey receiver, double amount){
        if(calculateBalance()< amount){
            return null;
        }
        List<TransactionsInput> inputs = new ArrayList<>();

        for (Map.Entry<String, TransactionsOutput> item: BlockChain.transactionMap.entrySet()){
            TransactionsOutput output = item.getValue();
            if(output.isMine(this.publicKey)){
                inputs.add(new TransactionsInput(output.getId()));
            }
        }

        Transaction newTransaction = new Transaction(publicKey, receiver,amount,inputs);
        newTransaction.generateSignature(privateKey);
        return newTransaction;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }


    public PublicKey getPublicKey() {
        return publicKey;
    }

}
