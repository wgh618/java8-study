package com.will.interfaces;

/**
 * ClassName:Defaulable
 * Description:接口的默认实现测试
 * @Author Will Wu
 * @Email willwu618@gmail.com
 * @Date 2017-12-12
 */
public interface Defaulable {
    /**
     * 接口的默认实现
     * @return
     */
    default String notRequired() {
        return "Default implementation";
    }
}
