package com.itlh.weather.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @Author Java小猪
 * @Date 2024/12/3 10:54
 */
public class Md5Utils {
    /**
     * MD5加密方法
     *
     * @param text 明文
     * @param key  秘钥
     * @return 密文
     */
    public static String md5(String text, String key) throws Exception {
        // 加密后的字符串
        return DigestUtils.md5Hex(text + key);
    }

    /**
     * MD5验证方法
     *
     * @param text 明文
     * @param key  秘钥
     * @param md5  密文
     * @return true
     */
    public static boolean verify(String text, String key, String md5) throws Exception {
        // 根据传入的密钥进行验证
        String md5Text = md5(text, key);
        if (md5Text.equalsIgnoreCase(md5)) {
            System.out.println("MD5验证通过!");
            return true;
        }
        System.out.println("密码错误!");
        return false;
    }

    // 测试方法
    public static void main(String[] args) throws Exception {
        // 注册：用户名tom 密码123456
        // 添加用户时，进行加密
        String testString = Md5Utils.md5("123456", "testKey");
        System.out.println("经MD5加密后的字符串为：" + testString);

        // 登录：用户名tom 密码123456     select * from user where username = tom and password = 123456
        // 根据用户名进行查询 f00485441dfb815c75a13f3c3389c0b9
        boolean verify = Md5Utils.verify("123456", "testKey", "bfc3217d2b23745b89f4c84ee53a5f49");
        System.out.println(verify);
    }
}

