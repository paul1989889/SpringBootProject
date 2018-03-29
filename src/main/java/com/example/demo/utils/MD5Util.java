package com.example.demo.utils;

import java.security.MessageDigest;
/**
 * MD5加密算法
 * @author tfq
 * @datetime 2011-10-13
 */
public class MD5Util {

    /***
     * MD5值
     */
    public static String encryptMD5(String inStr){
        MessageDigest md5 = null;
        try{
            md5 = MessageDigest.getInstance("MD5");
        }catch (Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)  {
            byteArray[i] = (byte) charArray[i];
        }
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++){
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)  {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();

    }

    /**
     * MD5加密
     */
    public static String decryptMD5(String inStr){

        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++){
            //按位异或
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;

    }

    // 不可逆的MD5 加密
    public static void main(String[] args) {
        String s = "123456";
        System.out.println("加密前：" + s);
        //生成MD5值
        String encryptResult = encryptMD5(s);
        System.out.println("MD5后：" + encryptResult);
        //加密
        String decryptResult = decryptMD5(encryptResult);
        System.out.println("MD5后加密：" + decryptResult);
        //解密
        String decryptResult2 = decryptMD5(decryptResult);
        System.out.println("解密为MD5后的：" + decryptResult2);
    }
}
