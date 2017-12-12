package com.will.interfaces;

import java.util.function.Supplier;

/**
 * ClassName:DefaulableFactory
 * Description:接口可以声明（并且可以提供实现）静态方法
 * @Author Will Wu
 * @Email willwu618@gmail.com
 * @Date 2017-12-12
 */
public interface DefaulableFactory {

    /**
     * 创建
     * @param supplier
     * @return
     */
    static Defaulable create(Supplier<Defaulable> supplier) {
        return supplier.get();
    }
}
