/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhom7.thh.meomeonoteserver.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Phạm Ngọc Hoàng - B16DCCN159
 */
public class BaseUtils {
    //Ma hoa mat khau
    public static String hashingPassword(String matKhau, String alg) {
        MessageDigest digest = null;
        String hex;
        StringBuffer hexString;
        try {
            digest = MessageDigest.getInstance(alg);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] hash = digest.digest(matKhau.getBytes(StandardCharsets.UTF_8));
        hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
