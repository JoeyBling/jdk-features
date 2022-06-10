package com.tynet;

import com.tynet.base.BaseTest;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Collectors;

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
        System.out.println("-".repeat(10));
        final List<String> languages = List.of("Java", "Kotlin", "Groovy");
        final var language = languages.stream()
                .map(x -> x.toUpperCase())
                // 自动类型推断
                .map((@NotNull var x) -> x.toUpperCase())
                .collect(Collectors.joining(", "));
        System.out.println(language);
    }

    /**
     * just test
     */
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.version"));
        System.out.println(Charset.defaultCharset());
    }

}
