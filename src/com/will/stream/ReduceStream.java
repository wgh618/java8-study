package com.will.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ClassName:ReduceStream
 * Description:
 *
 * @Author Will Wu
 * @Email will_wu@yunquna.com
 * @Date 2020/4/29 20:39
 */
public class ReduceStream {
    public static void main(String[] args) {
      /*  List<Long> list = Arrays.asList(1L,2L,3L,4L,5L,6L,7L,8L,9L);

        Long reduce = list.parallelStream().reduce(0L, (a, b) -> a + b);
        System.out.println(reduce);
        reduce = list.parallelStream().reduce(0L, Long::sum);
        System.out.println(reduce);

        Optional<Long> reduce1 = list.parallelStream().reduce(Long::max);
        System.out.println(reduce1.get());
*/
        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0]+n[1]})
                .limit(20)
                .forEach( t -> System.out.println("(" + t[0] + "," + t[1] + ")"));

    }
}
