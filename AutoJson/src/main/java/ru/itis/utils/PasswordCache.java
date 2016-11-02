package ru.itis.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by Span on 24.10.2016.
 */
public class PasswordCache {
    public static String getCache(String password) {
        String md5Hex = DigestUtils.md5Hex(password);
        return md5Hex;
    }
}
