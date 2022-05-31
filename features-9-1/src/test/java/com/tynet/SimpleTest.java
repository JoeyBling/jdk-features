package com.tynet;

import com.tynet.base.BaseTest;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

/**
 * 简单测试
 *
 * @author Created by 思伟 on 2022/5/11
 */
public class SimpleTest extends BaseTest {

    /**
     * 基础测试
     */
    @Test
    public void baseTest() {
        logger.debug("{}", Stream.ofNullable(null));
    }

    /**
     * just test
     */
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.version"));
    }

}
