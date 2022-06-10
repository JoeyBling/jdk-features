package com.tynet;

import com.tynet.base.BaseTest;
import org.junit.jupiter.api.Test;

import java.awt.*;
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
    }

    public abstract sealed class Shape
            permits Circle {

    }

    public final class Circle extends Shape {

    }

    /**
     * 转为{@link String}.
     *
     * @param val {@literal Object}
     * @return {@link String}
     */
    public static String toString(Object val) {
        return switch (val) {
            case Integer
                i -> String.format("int %d", i);
            case Long
                l -> String.format("long %d", l);
            case Double
                d -> String.format("double %f", d);
            case String
                str -> String.format("String %s", str);
                // 默认处理
                default -> Objects.toString(val);
        };
    }

    /**
     * just test
     */
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.version"));
    }

}
