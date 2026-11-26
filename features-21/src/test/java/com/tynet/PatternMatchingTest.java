package com.tynet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PatternMatchingTest {

    /**
     * 嵌套记录模式与 {@code when} 条件
     */
    @Test
    void routesOrdersUsingNestedRecordPatternsAndAGuard() {
        assertEquals("自提/Ada", destination(new Pickup("Ada")));
        assertEquals("同城/文一路", destination(new Delivery(new Address("杭州", "文一路"))));
        assertEquals("上海/南京路", destination(new Delivery(new Address("上海", "南京路"))));
    }

    /**
     * 空订单与空地址的处理
     */
    @Test
    void handlesNullAtBothLevelsOfThePattern() {
        assertEquals("待补地址", destination(new Delivery(null)));
        assertEquals("待履约", destination(null));
    }

    /**
     * 生成履约说明
     */
    private static String destination(Fulfillment fulfillment) {
        // 编译器检查密封类型的分支是否齐全
        return switch (fulfillment) {
            case Pickup(String customer) -> "自提/" + customer;
            case Delivery(Address(String city, String street)) when "杭州".equals(city) -> "同城/" + street;
            case Delivery(Address(var city, var street)) -> city + "/" + street;
            // 空地址落到外层 Delivery 分支
            case Delivery delivery -> "待补地址";
            case null -> "待履约";
        };
    }

    private sealed interface Fulfillment permits Pickup, Delivery {
    }

    private record Pickup(String customer) implements Fulfillment {
    }

    private record Delivery(Address address) implements Fulfillment {
    }

    private record Address(String city, String street) {
    }
}
