package com.tynet;

import com.tynet.base.BaseTest;
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
    }

    public abstract sealed class Shape
            permits Circle {

    }

    public final class Circle extends Shape {

    }

    /**
     * 转为{@link String}.
     *
     * @param val 非空对象
     * @return {@link String}
     */
    public static String toString(Object val) {
        Objects.requireNonNull(val);
        if (val instanceof Integer i) {
            return String.format("int %d", i);
        }
        if (val instanceof Long l) {
            return String.format("long %d", l);
        }
        if (val instanceof Double d) {
            return String.format("double %f", d);
        }
        if (val instanceof String str) {
            return String.format("String %s", str);
        }
        return val.toString();
    }

    /**
     * just test
     */
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.version"));
    }

}
