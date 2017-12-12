package com.will.interfaces;

/**
 * ClassName:OverridableImpl
 * Description:重写接口的默认方法
 * @Author Will Wu
 * @Email willwu618@gmail.com
 * @Date 2017-12-12
 */
public class OverridableImpl implements Defaulable {
    @Override
    public String notRequired() {
        return "Overridden implementation";
    }
}
