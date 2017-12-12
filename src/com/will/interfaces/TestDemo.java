package com.will.interfaces;

/**
 * ClassName:TestDemo
 * Description:test
 *
 * @Author Will Wu
 * @Email willwu618@gmail.com
 * @Date 2017-12-12
 */
public class TestDemo {
    public static void main(String[] args) {
        Defaulable defaultable = new DefaultableImpl();
        System.out.println(defaultable.notRequired());

        Defaulable overridable = new OverridableImpl();
        System.out.println(overridable.notRequired());
        System.out.println("***********************");
        Defaulable defaulable = DefaulableFactory.create(DefaultableImpl::new);
        System.out.println( defaulable.notRequired() );

        defaulable = DefaulableFactory.create(OverridableImpl::new);
        System.out.println( defaulable.notRequired() );
    }
}
