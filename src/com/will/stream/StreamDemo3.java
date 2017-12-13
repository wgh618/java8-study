package com.will.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * ClassName:StreamDemo2
 * Description:Stream API基本操作
 *
 * @Author Will Wu
 * @Email willwu618@gmail.com
 * @Date 2017-12-13
 */
public class StreamDemo3 {
    private static List<String> stringList = new ArrayList<>();

    static {
        stringList.add("ddd2");
        stringList.add("aaa2");
        stringList.add("bbb1");
        stringList.add("aaa1");
        stringList.add("bbb3");
        stringList.add("ccc1");
        stringList.add("bbb2");
        stringList.add("ddd1");
    }

    /**
     * Filter过滤:过滤通过一个predicate接口来过滤并只保留符合条件的元素，该操作属于中间操作，
     * 所以我们可以在过滤后的结果来应用其他Stream操作（比如forEach）。forEach需要一个函数来对过滤后的元素依次执行。
     * forEach是一个最终操作，所以我们不能在forEach之后来执行其他Stream操作。
     */
    public static void filter() {
        stringList.stream().filter(e -> e.startsWith("a")).forEach(System.out::println);
        System.out.println(stringList);
    }

    /**
     * Sort排序:排序是一个中间操作，返回的是排序好后的Stream。如果你不指定一个自定义的Comparator则会使用默认排序。
     * 需要注意的是，排序只创建了一个排列好后的Stream，而不会影响原有的数据源，排序之后原数据stringCollection是不会被修改的
     */
    public static void sort() {
        stringList.stream().sorted().filter(e -> e.startsWith("a")).forEach(System.out::println);
        System.out.println(stringList);
    }

    /**
     * Map映射:中间操作map会将元素根据指定的Function接口来依次将元素转成另外的对象
     * 将字符串转换为大写字符串，并逆序排序
     */
    public static void map() {
        stringList
                .stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);
        System.out.println(stringList);
    }

    /**
     * Match匹配:Stream提供了多种匹配操作，允许检测指定的Predicate是否匹配整个Stream。
     * 所有的匹配操作都是最终操作，并返回一个boolean类型的值。
     */
    public static void match() {
        boolean anyStartsWithA = stringList
                .stream()
                .anyMatch((s) -> s.startsWith("a"));
        // true
        System.out.println(anyStartsWithA);

        boolean allStartsWithA = stringList
                .stream()
                .allMatch((s) -> s.startsWith("a"));
        // false
        System.out.println(allStartsWithA);

        boolean noneStartsWithZ = stringList
                .stream()
                .noneMatch((s) -> s.startsWith("z"));
        // true
        System.out.println(noneStartsWithZ);

        System.out.println(stringList);
    }

    /**
     * Count计数:计数是一个最终操作，返回Stream中元素的个数，返回值类型是long。
     */
    public static void count() {
        long startsWithB = stringList
                .stream()
                .filter((s) -> s.startsWith("b"))
                .count();
        // 3
        System.out.println(startsWithB);

        System.out.println(stringList);
    }

    /**
     * Reduce规约:这是一个最终操作，允许通过指定的函数来将stream中的多个元素规约为一个元素，规越后的结果是通过Optional接口表示的：
     */
    public static void reduce() {
        Optional<String> reduce = stringList
                .stream()
                .sorted()
                .reduce((a, b) -> a + "&" + b);
        //aaa1&aaa2&bbb1&bbb2&bbb3&ccc1&ddd1&ddd2
        reduce.ifPresent(System.out::println);
        System.out.println(stringList);
    }

    /**
     * 并行Streams:前面提到过Stream有串行和并行两种，串行Stream上的操作是在一个线程中依次完成，而并行Stream则是在多个线程上同时执行
     */
    public static void parallel() {
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        // 串行操作
        long t0 = System.nanoTime();

        long count = values.stream().sorted().count();
        System.out.println(count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));

        // 并行操作
        t0 = System.nanoTime();

        count = values.parallelStream().sorted().count();
        System.out.println(count);

        t1 = System.nanoTime();

        millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("parallel sort took: %d ms", millis));
    }

    public static void main(String[] args) {
        filter();
        sort();
        map();
        match();
        count();
        reduce();
        parallel();
    }
}
