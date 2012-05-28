/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helper.escrowsys.security;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author kuuga
 */
public class AESEncryptor {

    private static final String ALGORITHM = "AES128";
    private static final byte[] keyValue = new byte[]{'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', '5', '5', 'y', '5', 't', '3', 'm', '6'};/*"G4rud4G055y5t3m605".getBytes();*///new byte[] { 'K', '3', 'Y', 'm', '4', 'n', '4', '6', '3', 'm', '3', 'N', 'D', '0', 'K', 'U' };


    public static String encrypt(String valueToEnc, String keyString) throws Exception {
        Key key = generateKey(keyString);
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encValue = c.doFinal(valueToEnc.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encValue);
        return encryptedValue;
    }

    public static String decrypt(String encryptedValue, String keyString) throws Exception {
        Key key = generateKey(keyString);
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedValue);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }

    private static Key generateKey(String keyString) throws Exception {
        Key key = new SecretKeySpec(keyString.getBytes(), ALGORITHM);
        return key;
    }

    public static void main(String[] args) throws Exception {

        String hash = "";

        String key = "aaaaaaaaaaaaaaaa";
        String password = hash;
        String passwordEnc = AESEncryptor.encrypt(password, key);
        String passwordDec = AESEncryptor.decrypt("oMgBvnxJUWHt9DPAyn2TQ9CzFTeEnBt3m7gsILEoIdhhxgL55nERhngRrBUULocg", "aaaaaaaaaaaaaaaa");

        

    }
}
