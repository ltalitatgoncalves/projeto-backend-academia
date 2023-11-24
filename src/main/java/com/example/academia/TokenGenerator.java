package com.example.academia;

import java.util.UUID;

public class TokenGenerator {
    public static String generateToken() {
        UUID uuid = UUID.randomUUID();
        String token = uuid.toString().replace("-", "");
        return token;
    }

    public static void main(String[] args) {
        String generatedToken = generateToken();
        System.out.println("Generated Token: " + generatedToken);
    }
}
