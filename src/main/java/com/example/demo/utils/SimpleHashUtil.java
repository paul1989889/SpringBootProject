package com.example.demo.utils;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * Created by lenovo on  三月
 */
public class SimpleHashUtil {
    /**
     * 明文密码进行加密
     * @param args
     */
    public static void main(String[] args) {
        int hashIterations = 2;    //加密的次数
        Object salt = "saltvip";   //盐值
        Object credentials = "123456";   //密码
        String hashAlgorithmName = "MD5";   //加密方式
        Object simpleHash = new SimpleHash(hashAlgorithmName, credentials,
                salt, hashIterations);
        System.out.println("加密后的值----->" + simpleHash);
    }
}
