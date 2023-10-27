package tech.ada.ecommerce;

import java.security.SecureRandom;
import java.util.Base64;

public class SecretKeyGenerator {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        byte[] secret = new byte[32]; // Use pelo menos 256 bits
        random.nextBytes(secret);
        String encodedSecret = Base64.getEncoder().encodeToString(secret);
        System.out.println(encodedSecret);
    }
}