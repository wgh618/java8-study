package com.will.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName:SelectStream
 * Description:
 *
 * @Author Will Wu
 * @Email will_wu@yunquna.com
 * @Date 2020/4/29 19:42
 */
public class MappingStream {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("abcd","dghj","ghyr");

        List<String> collect =
                list.stream().map(e -> e.split("")).flatMap(e1 -> Arrays.stream(e1)).distinct().collect(Collectors.toList());

        System.out.println(collect);
        
    }
}
