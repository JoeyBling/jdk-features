package com.tynet.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * 测试基类
 *
 * @author Created by 思伟 on 2022/5/31
 */
public abstract class BaseTest {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 防止程序提前结束
     * 不建议使用，会导致事务出问题
     */
    @Deprecated
    protected void avoidExit() {
        try {
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
