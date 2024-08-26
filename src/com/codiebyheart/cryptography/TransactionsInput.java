package com.codiebyheart.cryptography;

public class TransactionsInput {
    private  String transactionOutputId;
    private TransactionsOutput transactionsOutput;

    public TransactionsInput(String transactionOutputId) {
        this.transactionOutputId = transactionOutputId;
    }

    public String getTransactionOutputId() {
        return transactionOutputId;
    }

    public void setTransactionOutputId(String transactionOutputId) {
        this.transactionOutputId = transactionOutputId;
    }

    public TransactionsOutput getTransactionsOutput() {
        return transactionsOutput;
    }

    public void setTransactionsOutput(TransactionsOutput transactionsOutput) {
        this.transactionsOutput = transactionsOutput;
    }
}
