package com.tynet.module.demo.hessian;

/**
 * 自定义接口
 *
 * @author Created by 思伟 on 2022/5/31
 */
@Deprecated
public interface MyInterface {

    /**
     * 初始化
     */
    default void init() {
        System.out.println("初始化");
    }

}
