package ru.naumkin.tm.util;

import org.jetbrains.annotations.NotNull;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class HashGenerator {

    public static String getHash(@NotNull final String source) {
        try {
            @NotNull final MessageDigest md = MessageDigest.getInstance("SHA-512");
            @NotNull final String salt = "$0le#YI#@$h";
            md.update(salt.getBytes());
            md.update(source.getBytes());
            @NotNull final byte[] digest = md.digest();
            return bytesToHex(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static String bytesToHex(@NotNull final byte[] bytes) {
        @NotNull final StringBuilder builder = new StringBuilder();
        for (Byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }

}
