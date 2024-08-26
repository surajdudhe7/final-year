package com.codiebyheart.cryptography;

import java.security.*;
import java.security.spec.ECGenParameterSpec;

public class CryptoAlgorithm {

    public static String generateHash(String data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(data.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                String hexadecimal = Integer.toHexString(0xff & hash[i]);
                if (hexadecimal.length() == 1) hexString.append('0');
                hexString.append(hexadecimal);
            }
            return hexString.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);// Return null or an appropriate value in case of an error
        }
    }
    public static byte[] ECDSAsiganture(PrivateKey privateKey, String input){
        Signature signature;
        byte[] output = new byte[0];

        try{
            signature = Signature.getInstance("ECDSA" , "BC");
            signature.initSign(privateKey);
            byte[] strByte = input.getBytes();
            signature.update(strByte);
            byte[] realSignature = signature.sign();
            output = realSignature;


        }catch(Exception e){
            throw new RuntimeException(e);

        }
        return output;
    }
    public static KeyPair curveCrypto() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("ECDSA", "BC");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            ECGenParameterSpec parameterSpec = new ECGenParameterSpec("secp172k1");
            keyPairGenerator.initialize(parameterSpec, secureRandom);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            return keyPair;

            // Missing the rest of the code that would generate the key pair, but you said not to change it

        } catch (Exception e) {
           return null;
        }
    }
}
