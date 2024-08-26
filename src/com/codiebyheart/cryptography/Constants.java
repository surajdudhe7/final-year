package com.codiebyheart.cryptography;

public class Constants {

    // The difficulty level of the mining process, typically used in Proof of Work
    public static final int DIFFICULTY = 5;

    // The hash of the previous block in the blockchain, usually all zeros for the Genesis block
    public static final String GENESIS_PREV_HASH = "0000000000000000000000000000";

    // The reward given to miners for successfully mining a block
    public static final double MINER_REWARD = 12.5;

}
