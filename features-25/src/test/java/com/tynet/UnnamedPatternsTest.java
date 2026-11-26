package com.tynet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnnamedPatternsTest {

    /**
     * 用 {@code _} 忽略组件或变量
     */
    @Test
    void matchesOnlyTheComponentsNeededToReadTheEnvironment() {
        assertEquals("staging", environment(new Deployment("billing", "staging", 3)));
        assertEquals("default", environment("legacy deployment"));
        assertEquals("unknown", environment(42));
    }

    private static String environment(Object event) {
        return switch (event) {
            case Deployment(_, String environment, _) -> environment;
            case String _ -> "default";
            default -> "unknown";
        };
    }

    private record Deployment(String service, String environment, int revision) {
    }
}
