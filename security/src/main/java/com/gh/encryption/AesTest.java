package com.gh.encryption;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.junit.Before;
import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;

/**
 * @author sso team
 * @description AES加密
 * @date 2021/9/29 11:27 上午
 */
public class AesTest {

    // 算法
    private static String algorithm = "AES";

    private static Cipher cipher;

    @Before
    public void before() throws NoSuchPaddingException, NoSuchAlgorithmException {
        cipher = Cipher.getInstance(algorithm);
    }

    /**
     * 加密方法
     * @param key 密钥 长度为8
     * @param origin 原文
     * @return 密文
     * @throws Exception any
     */
    public static String encryptDes(String key, String origin) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] bytes = cipher.doFinal(origin.getBytes());
        return Base64.encode(bytes);
    }

    /**
     * 解密方法
     * @param key 密钥 长度为8
     * @param secret 密文
     * @return 原文
     * @throws Exception any
     */
    public static String decryptDes(String key, String secret) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), algorithm);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] bytes = cipher.doFinal(Base64.decode(secret));
        return new String(bytes);
    }

    @Test
    public void testEncrypt() throws Exception {
        // 原文
        String input = "to do or not tod";
        // 定义key, 如果使用DES加密，密钥必须是8位字节
        String key = "1234567887654321";
        // 调用加密方法
        System.out.println(encryptDes(key, input));
    }

    @Test
    public void testDecrypt() throws Exception {
        // 原文
        String input = "to do or not tod";
        // 定义key, 如果使用DES加密，密钥必须是8位字节
        String key = "1234567887654321";
        String encryptDes = encryptDes(key, input);
        String origin = decryptDes("!QAZ@WSX#EDC4rfv5tgb6yhn", "c6e2923a3f9eb12705653768b766e91d47de67a874e92eb091c2c9136bd56a8d");
        System.out.println(origin);
    }

}
