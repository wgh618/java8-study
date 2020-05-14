package com.will.collect;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:Test
 * Description:
 *
 * @Author Will Wu
 * @Email will_wu@yunquna.com
 * @Date 2020/5/13 20:32
 */
public class Test {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("11",11));
        users.add(new User("22",22));
        users.add(new User("33",33));
        users.add(new User("44",44));
        List<String> collect = users.stream().map(User::getName).collect(new ToListCollector<>());
        System.out.println(collect);
    }
}
