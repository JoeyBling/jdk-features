package com.tynet;

import com.tynet.base.BaseTest;
import org.junit.jupiter.api.Test;

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
        final String language = "Java\nKotlin\nGroovy";
        // 缩进
        System.out.println(language.indent(10));
    }

    /**
     * just test
     */
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.version"));
    }

}
