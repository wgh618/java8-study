package com.will.stream;

import java.util.ArrayList;
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
public class SelectStream {
    public static void main(String[] args) {
        List<Long> list = Arrays.asList(1L,2L,3L,4L,5L,6L,7L,8L,9L);

        List<Long> collect = list.stream().skip(4).limit(3).collect(Collectors.toList());

        System.out.println(collect);
        
    }
}
