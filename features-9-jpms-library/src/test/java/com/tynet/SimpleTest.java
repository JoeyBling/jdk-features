package com.tynet;

import com.tynet.base.BaseTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
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
        // Stream API
        logger.debug("{}", Stream.ofNullable(null));

        Optional.ofNullable(null).stream().forEach(System.out::println);

        // 集合工厂方法 <p>不可变实例
        final List<Integer> list = List.of(1, 2, 3, 10, 11, 4, 5, 6);
        list.stream().takeWhile(x -> x < 10).forEach(System.out::println);
        logger.info("----------");
        list.stream().dropWhile(x -> x < 10).forEach(System.out::println);
    }

    /**
     * just test
     */
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.version"));
    }

}
