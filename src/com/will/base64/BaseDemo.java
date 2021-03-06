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
            String myjf = "KACiFWOm8SehAiOjqm+j7eOhaeOm8S+gwi+LgE5jlDIvlHqilrJuk/4hp76lp" +
                    "/rrofKplHIgjH5jlDIvlHqro7rron5qnHZvnvonlfKplnInmzIvvH5jlDIvlDiYldFIJKo5fa45BC441AyiAKuCgsJvvfIom76mn76mnnbopDJim7rvobbulXZslv5vo76mnnbopjqiljqjmjqilvLuk7oukTollzIvvvpil37gobIknTIplvKilb4ronamp74op3bpl/aiofIplfbhlHIgjTjCgsJvvfbhlX6tlHqro7rroDCTNVFIoS55/2L5Du75fa45My77h6K6+6K6Gu75m+K6MKZ5h6K6+6K6BaK6Caq5BC44h6K6+6K6E6p526p5aCY6+K75BC44zoAIby773WY5leb5V+K6DCL6vAyioeul8eOqUeOu4WOjSW+giW+rOe+ioeul8eOI4Vnbpx0LYlkTVBSiCa+nGeOj8+Ojqm+j7e+sFW+uUaOmimuvam+rcaOgKaeicaOj8+uteauhhaOk6aOg8Weg1a+u4SuiPWep7SOIMF1U51UgAOeY2FmSgoJgp7rsnHIgjLjCgsJvvzoqp/4unzZvkX6tl3YvkfpslPbhlj7mnrIukX6ukTbulDSNtMDj8+uhOWuptWui4Sep7SuiPWekneOrcaum4S+k4S+sFWOubeeiteuuca+lueeouiegAOeMKASXggIulvIqnX6tlH5jlDIvlDSY2FmSbpgCgY4ro/IhmHqil3InmfLimLqrlTomn3bpl/aiozIvvvqukbIil7oukDZukzIvvvpil37gorJgp/psmHIgjzZvk/Yjl/JmpL6mlTomn3bpl/aionInmfbhlDiL4oAIby77IWY5YyL5FCI6Mqa6Pu75R+Y5Ayb5uu555Ga6Qqr5Ayb5Jyp53WY5g4yNKAym8+OiFWOm8SehAiOjqm+j7eOqUe+v9SOItJ3bmRXYsBFIkV3bsNEIlx2Zv92RBC44TdVQgkInmfbhlDiL2oAIby77c2L5leb5J265kqo50u75BC44y275oOY6BC44R+Y5Ayb5Eq55LiL5fu757O75c2L5NOp5ggXdulGTvgXauVFIJKo5fa45g4SNKAym8+uteauhhaekPWOg8WOIiV2dgkYrnDyazFGbm9ybn5WYqREIJKo5fa45g4CNKAym8++ioeul8eOn7eek9eumAmuvyeOj8++ioeul8e+rreeoKWejcaOIu9Ga0lHUgoJgp7rsnDiLzoAIby77vOo5gmL5BC65Wy75Eq559Wa5vmI6Jyp53WY5My77Mqa6Pu75R+Y5Ayb5w+Y5OCZ5g42boRXeQBii4Sep7SOt5WOIywIvv72boRXeQBimAmuvyeOIuIjCgYojlbarlrIukX6ukr4jlH5pnzKnmrJukPJukPbhlj7mnrLnmfprnHqroDiLxoAIdBCi4W+ioeep3WekPWOg8WOIu9Ga0lHcgslCKAym8+OiFWOm8SehAiOjqm+j7eOn9Sep3WulkW+t1a+hkW+tFWOj8++mKWevDiumAm+nyaerviulkWOhaeevlW+rJiOIucjCgsJvvDCiFWOm8SehAiOjqm+j7eOt7eOk/i+LgE5jlDIvl/5unv7snfJil/Jmp/agmjotmr4jl/5unv7snfprnHqro/IvlPIulbIilnYrnDSYrZWYr9CajJXYlN3YpR3chxWZv0mcvR3cvsmbpxmRvsmchB3cvA3bvRWYoBSica+tFWOIuYjCgsJvvjYhljJvkzoqp/4unHqro7rroTonmbrnmzoklbqulPIsoTqvnb4mpHKqmT4pofKplnInmfbhlzIvvjYhljJvkXIgo/ammz4goHqilrJukLKtnzJkmbJimrYkl/bulnInmfbhlDiL1oAIby77G+K6PSo5hqY5Nyp53io5i6a5Eq559Wa5vmI6My77rqL5GiY5OqL5QmL5My77bqY59OI6aCY6fKr5BC44c2L5P2Y5fiZ6iuZ5Eq559Wa5vmI6Jyp53WY5g4CNKAym8+et3iunuWOjSW+oniuhQeOhae+uIWes3aeica+hNWOkPaevDiOiVaOjSWutIW+pOaOrcaOkIaeuvWOj8+uvuiuu7W+n7e+uzeOt7eOk/ieiteeuuWeqJaOqKWuqHiegAOus9eOqDm+gFWelNWegAOuhQeeoueeoKWejcaeiCa+nGeOIuMjCgsJvvjIklTblmTomnjYomnrlm/KnmDoimzYoov5voDSvDiut5WOj8+Ojqm+j7eepfaukOaOnamehVaOjSWup6W+nEa+jVa+rcaOgKauu8WOi+Weica+tFWOj8+ei8+eiteOIvl2Lgw5unHZvnjIvvHqil3Inm/6to77kpjLumvIukrIukr4jlnIvvDCe15WasBCi8++n7e+uze+oniuh6SepFWes3aOj8+Orhe+h/iunuWujJa+mKWevDi+ioeep3W+n7e+uzeOIuIjCgsJvvjYhljJvkXIgozoqp/4unH5jlDIvl76mnnbopDpumDIvlnInmfbhlzIvvDCiFWOm8SOIhZXYKBShAiulIa+KrM0LDxIvvDIqo36rovIqnbJvnj6lpDIukHJslP7hoH6jmzojmzIvvTonmbrnm/5unv7snzoklH5jlDIvlb7uk/avonogm/phnzIvvzoqp/4unT7unD5vojJim7prlTqvnb4mpHKqmT4pofKplTomnrIukX6ukTbulDyMg4SMKASXggIulvIqnX6tlT7unD5vojKlnTpulvlCKASNQBChae+mKWOn9aOmrmOj8++NQxIvvbDUJozp6eugxWugxaegmiuCgcbtmrIukzIvv37gpDJimzIvv75tl3anmngO5K45wyZ5c2L5leb5KAigAO+jHm+mKWumdWer4SOhaeOqKW+u0aehMWuo6eepYaOsWaOjSWOIyEDIM+Y5BC44xEDIM+Y50mb5P+q5vip5My77cqZ6d+L5nCo5a6a5zi65MKZ5n6o5Kqo5Eq55pmZ6OOa6vyp5Aqo5Nyp5ReY6BqJ6CqJ6qiL50Wp5jSL6fSL6oeZ6oOY6oyZ5Amo5My77GuZ6RqL5bm45nSa5gEmdhpUgAOubvhGd5BFj8+uptWOjQWus5WOqqmOhaeOI4AFI6iL5H2Y5Lmp5FaY50mb5gUDj8++NQBiu4S+hNW+iZaehGWOt5WOIzAimkWOi+WOqDm+rcaOgKaOsPW+s5Wum8++i7SOgueOqXmOqDmuCgg6gpnamp74op/KnmDoim3CqDm+rcaOgKaOsPW+s5WeLNyp5ReY6BqJ6CqJ6JoDqXmOqDm+LVJkC";
            System.out.println(base64Decoder(new StringBuffer(myjf).reverse().toString()));
            System.out.println(base64Encoder("hello world java8 base64"));
            System.out.println(base64Decoder(base64Encoder("hello world java8 base64")));
            System.out.println();
            System.out.println(base64URLEncoder("www.test.com/oa"));
            System.out.println(base64URLDecoder(base64URLEncoder("www.test.com/oa")));
            System.out.println("--------------");
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 5; i++) {
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
        byte[] asByte = Base64.getDecoder().decode(str);
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
    public static String base64URLDecoder(String str) throws UnsupportedEncodingException {
        byte[] asByte = Base64.getUrlDecoder().decode(str);
        return new String(asByte, StandardCharsets.UTF_8);
    }

    /**
     * MIME编码：使用基本的字符数字产生的Base64输出，而且对MIME格式友好：每行输出不超过76个字符，而且每行以"\r\n"符结束
     */
    public static String base64MIMEEncoder(String str) throws UnsupportedEncodingException {
        byte[] toEncode = str.getBytes(StandardCharsets.UTF_8);
        return Base64.getMimeEncoder().encodeToString(toEncode);
    }

    /**
     * MIME解码
     */
    public static String base64MIMEDecoder(String str) throws UnsupportedEncodingException {
        byte[] asByte = Base64.getMimeDecoder().decode(str);
        return new String(asByte, StandardCharsets.UTF_8);
    }

}
