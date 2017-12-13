package com.will.base64;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.UUID;

/**
 * ClassName:BaseDemo
 * Description:Base64加密解密
 *
 * @Author Will Wu
 * @Email willwu618@gmail.com
 * @Date 2017-12-13
 */
public class BaseDemo {
    public static void main(String[] args) {
        try {
            System.out.println(base64Encoder("hello world java8 base64"));
            System.out.println(base64Decoder(base64Encoder("hello world java8 base64")));
            System.out.println();
            System.out.println(base64URLEncoder("www.test.com/oa"));
            System.out.println(base64URLDecoder(base64URLEncoder("www.test.com/oa")));
            System.out.println("--------------");
            StringBuilder stringBuilder=new StringBuilder();
            for (int i = 0;i<5;i++){
                stringBuilder.append(UUID.randomUUID().toString());
            }
            System.out.println(stringBuilder);
            System.out.println(base64MIMEEncoder(stringBuilder.toString()));
            System.out.println(base64MIMEDecoder(base64MIMEEncoder(stringBuilder.toString())));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 编码
     */
    public static String base64Encoder(String str) throws UnsupportedEncodingException {
        return Base64.getEncoder().encodeToString(str.getBytes(StandardCharsets.UTF_8));
    }
    /**
     * 解码
     */
    public static String base64Decoder(String str) throws UnsupportedEncodingException {
        byte[] asByte=Base64.getDecoder().decode(str);
        return new String(asByte, StandardCharsets.UTF_8);
    }

    /**
     * url编码:使用下划线"_"替换了url的反斜杠"/"
     */
    public static String base64URLEncoder(String str) throws UnsupportedEncodingException {
        return Base64.getUrlEncoder().encodeToString(str.getBytes(StandardCharsets.UTF_8));
    }
    /**
     * url解码
     */
    public static  String base64URLDecoder(String str)throws UnsupportedEncodingException{
        byte[] asByte=Base64.getUrlDecoder().decode(str);
        return  new String(asByte, StandardCharsets.UTF_8);
    }

    /**
     * MIME编码：使用基本的字符数字产生的Base64输出，而且对MIME格式友好：每行输出不超过76个字符，而且每行以"\r\n"符结束
     */
    public static String base64MIMEEncoder(String str) throws UnsupportedEncodingException {
        byte[] toEncode=str.getBytes(StandardCharsets.UTF_8);
        return Base64.getMimeEncoder().encodeToString(toEncode);
    }

    /**
     * MIME解码
     */
    public static String base64MIMEDecoder(String str) throws UnsupportedEncodingException {
        byte[] asByte=Base64.getMimeDecoder().decode(str);
        return  new String(asByte, StandardCharsets.UTF_8);
    }

}
