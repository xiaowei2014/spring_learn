package my.learn.spring.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by 张小伟 on 2015/11/28.
 */
public class DESUtils {

    //指定DES加密解密所用的秘钥
    private static Key key;
    private static String KEY_STR="mykey";

    static {
        try {
            KeyGenerator generator = KeyGenerator.getInstance("DES");
            generator.init(new SecureRandom(KEY_STR.getBytes()));
            key = generator.generateKey();
            generator = null;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 对字符串进行DES加密，返回BASE64编码的加密字符串
     * @param str
     * @return
     */
    public static String getEncryptString(String str){
        BASE64Encoder base64Encoder = new BASE64Encoder();
        try {
            byte[] bytes =str.getBytes("UTF8");
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE,key);
            byte[] encryptBytes = cipher.doFinal(bytes);
            return base64Encoder.encode(encryptBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getDecryptString(String str){
        BASE64Decoder base64Decoder = new BASE64Decoder();
        try {
            byte[] bytes = base64Decoder.decodeBuffer(str);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptBytes = cipher.doFinal(bytes);
            return new String(decryptBytes,"UTF8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
