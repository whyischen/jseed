package com.whyischen.jseed.basic.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Base64;

public class AESUtil {

    private static final byte[] IV = "Z91OgVh02n6XxBxC".getBytes(StandardCharsets.UTF_8);

    private static final String CIPHER_MODE = "AES/CBC/PKCS5Padding";
    private static final String AES = "AES";

    /**
     * 加密
     *
     * @param password 密码
     * @param content  加密内容
     */
    public static String encrypt(String password, String content) throws GeneralSecurityException {
        if (password == null || content == null ||
                password.length() == 0 || content.length() == 0) {
            throw new GeneralSecurityException();
        }

        var key = password.getBytes(StandardCharsets.UTF_8);
        var input = content.getBytes(StandardCharsets.UTF_8);

        Cipher cipher = Cipher.getInstance(CIPHER_MODE);
        SecretKeySpec keySpec = new SecretKeySpec(key, AES);
        IvParameterSpec initVector = new IvParameterSpec(IV);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, initVector);
//        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] data = cipher.doFinal(input);

        return Base64.getEncoder().encodeToString(data);
    }

    /**
     * 解密
     *
     * @param password 密码
     * @param content  解密内容
     */
    public static String decrypt(String password, String content) throws GeneralSecurityException {
        if (password == null || content == null ||
                password.length() == 0 || content.length() == 0) {
            throw new GeneralSecurityException();
        }

        var key = password.getBytes(StandardCharsets.UTF_8);
        var input = Base64.getDecoder().decode(content);

        // 解密:
        Cipher cipher = Cipher.getInstance(CIPHER_MODE);
        SecretKeySpec keySpec = new SecretKeySpec(key, AES);
        IvParameterSpec initVector = new IvParameterSpec(IV);
        cipher.init(Cipher.DECRYPT_MODE, keySpec, initVector);
//        cipher.init(Cipher.DECRYPT_MODE, keySpec);

        return new String(cipher.doFinal(input));
    }

    public static void main(String[] args) throws GeneralSecurityException {
        var content = "Hello, WeiHua!";
        var password = "PVVZk1GEk3BmcK6JE9s7abSv7oQRFFAs";
        // 加密
        var encrypted = encrypt(password, content);
        System.out.println("Encrypted: " + encrypted);
        // 解密:
        var decrypted = decrypt(password, encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}
