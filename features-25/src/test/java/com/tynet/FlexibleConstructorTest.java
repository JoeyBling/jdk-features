package com.tynet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FlexibleConstructorTest {

    /**
     * 调用父类构造器前校验参数
     */
    @Test
    void normalizesAndValidatesTheNameBeforeCallingSuper() {
        User user = new RegisteredUser(" Ada ");

        assertEquals("Ada", user.name);
        assertThrows(IllegalArgumentException.class, () -> new RegisteredUser("   "));
    }

    private static class User {
        private final String name;

        User(String name) {
            this.name = name;
        }
    }

    private static final class RegisteredUser extends User {
        RegisteredUser(String name) {
            String normalized = name.strip();
            if (normalized.isEmpty()) {
                throw new IllegalArgumentException("name must not be blank");
            }
            // 读取当前实例的字段须等到 super 返回
            super(normalized);
        }
    }
}
