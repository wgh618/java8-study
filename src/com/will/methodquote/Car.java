package com.will.methodquote;

import java.util.function.Supplier;

/**
 * ClassName:Car
 * Description:方法引用
 * @Author Will Wu
 * @Email willwu618@gmail.com
 * @Date 2017-12-12
 */
public class Car {
    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(Car car) {
        System.out.println( "Collided " + car.toString() );;
    }

    public void follow(final Car car) {
        System.out.println( "Following the " + car.toString() );
    }

    public void repair() {
        System.out.println( "Repaired " + this.toString() );
    }
}
