package com.tynet;

import com.tynet.base.BaseTest;
import com.tynet.module.demo.Dog;
import org.junit.jupiter.api.Test;

import java.util.Objects;

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
        final var dog1 = new Dog("牧羊犬", 1);
        System.out.println(toString(dog1));
    }

    /**
     * 转为{@link String}.
     *
     * @param val {@literal Object}
     * @return {@link String}
     */
    public static String toString(Object val) {
        if (val instanceof String str) {
            // Let pattern matching do the work.
            return str;
        } else if (val instanceof Dog dog) {
            return dog.toString();
        }
        // 默认处理
        return Objects.toString(val);
    }

    /**
     * just test
     */
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.version"));
    }

}
