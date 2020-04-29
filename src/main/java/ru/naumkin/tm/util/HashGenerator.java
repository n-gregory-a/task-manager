package ru.naumkin.tm.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashGenerator {

    public static String getHash(String source) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            String salt = "$0le#YI#@$h";
            md.update(salt.getBytes());
            md.update(source.getBytes());
            byte[] digest = md.digest();
            return bytesToHex(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (Byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }

}
