package com.wangpos.s_mvp.base.util;

import com.apt.InstanceFactory;


/**
 * Created by qiyue on 17/10/10.
 */
public class InstanceUtil {

    /**
     * 通过实例工厂去实例化相应类
     *
     * @param <T> 返回实例的泛型类型
     * @return
     */
//    @TimeLog
    public static <T> T getInstance(Class clazz) {
        try {
            /**
             * InstanceFactory 可以我们自己手动去写，现在通过编译时注解生成，只需要在对应的类上添加一个注解就好
             */
            return (T) InstanceFactory.create(clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
