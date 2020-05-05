package ru.naumkin.tm.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class HashGenerator {

    public static String getHash(final String source) {
        try {
            final MessageDigest md = MessageDigest.getInstance("SHA-512");
            final String salt = "$0le#YI#@$h";
            md.update(salt.getBytes());
            md.update(source.getBytes());
            final byte[] digest = md.digest();
            return bytesToHex(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static String bytesToHex(final byte[] bytes) {
        final StringBuilder builder = new StringBuilder();
        for (Byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }

}
