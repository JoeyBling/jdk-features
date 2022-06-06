package com.tynet;

import com.tynet.base.BaseTest;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        final var obj = List.of(1, 2, 3, 4, 5);
        System.out.println(obj == List.copyOf(obj));
    }

    /**
     * just test
     */
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.version"));
    }

}
