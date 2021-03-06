package com.PhotoApp.PhotoApp.shared;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

@Component
public class Utils {

    private final Random RANDOM = new SecureRandom();
    private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPRSTUVWXYZabcdefghijklmnoprstuvwxyz";

    public String generateUserId(int length)
    {
        return UUID.randomUUID().toString();
    }
    public String generateRandomString(int length){
        StringBuilder returnValue = new StringBuilder(length);
        for (int i=0; i < length; i++){
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return new String(returnValue);
    }
}
