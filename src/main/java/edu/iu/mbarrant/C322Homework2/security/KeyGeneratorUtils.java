package edu.iu.mbarrant.C322Homework2.security;

import java.security.KeyPair;
import java.security.KeyPairGenerator;



public class KeyGeneratorUtils {

    private KeyGeneratorUtils() {}

    public static KeyPair generateRsaKey() {
        KeyPair keyPair;
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            keyPair = keyPairGenerator.generateKeyPair();
        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
        return keyPair;
    }
}
