package com.codiebyheart.crypto;

import com.codiebyheart.cryptography.*;

import java.security.Security;

public class controller {

    public static void main(String[] args){
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        Wallet central = new Wallet();
        Wallet user_1 = new Wallet();
        Wallet user_2 = new Wallet();
        BlockChain chain = new BlockChain();

        //genesis transaction
        Transaction genesisTransaction = new Transaction(central.getPublicKey(), user_1.getPublicKey(), 500,null);
        genesisTransaction.generateSignature(central.getPrivateKey());
        genesisTransaction.setTransactionId("0");
        genesisTransaction.outputs.add(new TransactionsOutput(genesisTransaction.getReceiver(), genesisTransaction.getAmount(),genesisTransaction.getTransactionId()));

        BlockChain.transactionMap.put(genesisTransaction.outputs.get(0).getId(),genesisTransaction.outputs.get(0));

        System.out.println("The genesis Block");
        Block genesis = new Block(Constants.GENESIS_PREV_HASH);
        genesis.addTransaction(genesisTransaction);

        Block block1 = new Block(genesis.getHash());
        System.out.println("User 1 balance" + user_1.calculateBalance());
        block1.addTransaction((user_1.transferAmount(user_2.getPublicKey(),120)));
        System.out.println("User 1 balance is "+ user_1.calculateBalance());
        System.out.println("User 2 balance is "+ user_2.calculateBalance());

        Block block2 = new Block(block1.getHash()); // Assuming getHash() returns the hash of block1
        block2.addTransaction(user_1.transferAmount(user_2.getPublicKey(), 600)); // Example transaction for block2

// Display final balances
        System.out.println("User 1 final balance: " + user_1.calculateBalance());
        System.out.println("User 2 final balance: " + user_2.calculateBalance());

        Block block3 = new Block(block2.getHash());

        block3.addTransaction(user_2.transferAmount(user_1.getPublicKey(),110));
        System.out.println("User 2" + user_2.calculateBalance());
        System.out.println("User 1 "+ user_1.calculateBalance());

    }
}

