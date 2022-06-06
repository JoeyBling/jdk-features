package com.tynet.module.demo.domain;

import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

/**
 * just test
 *
 * @author Created by 思伟 on 2022/5/31
 */
@lombok.Data
public class Person {

    /**
     * just test
     */
    public static void main(String[] args) {
        @NotNull final String javaVersion = System.getProperty("java.version");
        System.out.println(javaVersion);

        System.out.println(Stream.ofNullable(null));
    }

}
