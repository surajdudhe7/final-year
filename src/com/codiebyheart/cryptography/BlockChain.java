package com.codiebyheart.cryptography;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BlockChain {
    public static ArrayList<Block> blocks;
    public static Map<String, TransactionsOutput> transactionMap;

    public BlockChain() {
        BlockChain.transactionMap = new HashMap<>();
        BlockChain.blocks = new ArrayList<>();
    }

    public void addBlock(Block block) {
        BlockChain.blocks.add(block);
    }

    public int size() {
        return BlockChain.blocks.size();
    }

    @Override
    public String toString() {
        String blockchain = "";
        for(Block block : BlockChain.blocks){
            blockchain += block.toString()+"/n";
        }
        return blockchain;
    }
}
