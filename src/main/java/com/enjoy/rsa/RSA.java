package com.enjoy.rsa;

import org.springframework.util.Base64Utils;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * <b>Author</b>: Hsiang Leekwok<br/>
 * <b>Date</b>: 2019/04/03 20:25<br/>
 * <b>Version</b>: v1.0<br/>
 * <b>Description</b>: RSA 加密解密的实现
 */
public class RSA {

    private static final String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIR1/tsXhL6z+IlOlRc6S6Pz/zQ6kkP5sLKUaJZDHfd27oYm6NhMMGeeFUOhMIqW+tTM1evVwfCZPku8YkHB0MWnprqwAUbe2Mu+3xT94LE3e3j3hCz48Lx8Xbu1cu44SfFQ69PN7IUUf5fQ1tuR2MQMESZ62jeh8i0m0mZJenPJAgMBAAECgYBtoDY3XwSGy+3SvY2Ydq+pVkONFzh8N4bslPTl/1AqwWxw7HzinlOlPej9WscQvBmFyqz1DKkAleM/zP5Iy74a1fO/CtegzIytnzh9ej/irs5lWIb2V+VtuYAyC7U5Z+18XElHIREHw/aWLoKHQKJB6Z6LSLH65rQknFNduO1J8QJBAMLrnyZ6X7LqrPliNXUtWrUoHRFwsf/xdb2LnMoE0CTZAYBTesrQzTeb9MbP92uUHB4BkZt+xSfOuZTSjA3uym0CQQCt9+sMIuB8ydQVwfzFHOg7MT92RVPLOG0Ukkg/Q0sybqVzLnhU2cJTqGqNMWUDyr/ECHzxFDn9zaEAWrgEWzVNAkAztBx7MGrCIs3POOXFN0qgUwui3KnaokoBBU+Jps0veQCU8Y/YzJoi7hN3ySJwPtFWhEQDYxUZAhToDRFpgLXhAkEAq2NkUDeH+8iGxcywLq0U6UPSZr1UGRCE/lBDFvg/+/Zfz0LHz6gct3hjSKiSARNcq09Fb+hiXXWYmRXG1pvYvQJAdrVAXCVDHXZW3bEJwHxGvyFm6lvdpFrblTsCZPkRJN48odQMdiIoroJoVU5PXGphvOnmuFJhAm9NSIlXvSI7hw==";
    private static final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCEdf7bF4S+s/iJTpUXOkuj8/80OpJD+bCylGiWQx33du6GJujYTDBnnhVDoTCKlvrUzNXr1cHwmT5LvGJBwdDFp6a6sAFG3tjLvt8U/eCxN3t494Qs+PC8fF27tXLuOEnxUOvTzeyFFH+X0NbbkdjEDBEmeto3ofItJtJmSXpzyQIDAQAB";

    private static void initKey() {
        // 初始化密钥
        KeyPairGenerator keyPairGenerator;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(1024);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            String pub = Base64Utils.encodeToString(keyPair.getPublic().getEncoded());
            System.out.println("public key: " + pub);
            String pri = Base64Utils.encodeToString(keyPair.getPrivate().getEncoded());
            System.out.println("private key: " + pri);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 加密字符串
     *
     * @param value 需要加密的字符串
     * @return 返回加密过后的秘闻
     */
    public static String encode(String value) {
        try {
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64Utils.decodeFromString(publicKey));
            byte[] result = transfer(keySpec, Cipher.ENCRYPT_MODE, value.getBytes(StandardCharsets.UTF_8));
//            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//            PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
//            Cipher cipher = Cipher.getInstance("RSA");
//            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
//            byte[] result = cipher.doFinal(value.getBytes(StandardCharsets.UTF_8));
            return Base64Utils.encodeToString(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密字符串
     *
     * @param security 加密过后的密文
     * @return 返回解密之后的明文
     */
    public static String decode(String security) {
        try {
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64Utils.decodeFromString(privateKey));
            byte[] result = transfer(keySpec, Cipher.DECRYPT_MODE, Base64Utils.decode(security.getBytes(StandardCharsets.UTF_8)));
//            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//            PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
//            Cipher cipher = Cipher.getInstance("RSA");
//            cipher.init(Cipher.DECRYPT_MODE, privateKey);
//            byte[] result = cipher.doFinal(Base64Utils.decode(security.getBytes(StandardCharsets.UTF_8)));
            return new String(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 进行加密或者解密过程
     * @param keySpec 密钥或公钥
     * @param mode 加密或解密模式
     * @param data 明文或密文的 byte[] 数组
     * @return 返回已加密或已解密的 byte[] 数组
     * @throws Exception
     */
    private static byte[] transfer(KeySpec keySpec, int mode, byte[] data) throws Exception {
        if (mode != Cipher.ENCRYPT_MODE && mode != Cipher.DECRYPT_MODE) {
            throw new UnsupportedOperationException("only support ENCRYPT_MODE and DECRYPT_MODE");
        }
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        Key key = mode == Cipher.ENCRYPT_MODE ? keyFactory.generatePublic(keySpec) : keyFactory.generatePrivate(keySpec);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(mode, key);
        return cipher.doFinal(data);
    }

    public static void main(String[] args) {
        //initKey();
        String password = "123456";
        String pwd = encode(password);
        String re = decode(pwd);
        System.out.println(password + ": " + encode(password));
        System.out.println("decode: " + re);
    }
}
