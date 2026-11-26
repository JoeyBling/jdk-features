package com.tynet;

import com.tynet.base.BaseTest;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

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
        final var dayOfWeek = LocalDate.now().getDayOfWeek();
        final var typeOfDay = switch (dayOfWeek) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> {
                // do sth...
                System.out.println("努力工作!!!");
                yield "Working Day";
            }
            case SATURDAY, SUNDAY -> "Day Off";
            default -> throw new IllegalStateException("Unexpected value: " + dayOfWeek);
        };
        System.out.println(typeOfDay);
    }

    /**
     * just test
     */
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.version"));
    }

}
