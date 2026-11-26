package com.tynet;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ScopedValueTest {

    private static final ScopedValue<String> REQUEST_ID = ScopedValue.newInstance();

    /**
     * 退出内层后恢复外层绑定
     */
    @Test
    void restoresThePreviousBindingAfterANestedCall() {
        String innerValue = ScopedValue.where(REQUEST_ID, "outer").call(() -> {
            assertEquals("outer", REQUEST_ID.get());

            String rebound = ScopedValue.where(REQUEST_ID, "inner").call(REQUEST_ID::get);

            assertEquals("outer", REQUEST_ID.get());
            return rebound;
        });

        assertEquals("inner", innerValue);
        assertFalse(REQUEST_ID.isBound());
    }

    /**
     * 异常退出时清理绑定
     */
    @Test
    void clearsTheBindingWhenTheOperationThrows() {
        assertThrows(IllegalStateException.class, () -> ScopedValue.where(REQUEST_ID, "request-42").run(() -> {
            assertEquals("request-42", REQUEST_ID.get());
            throw new IllegalStateException("request failed");
        }));

        assertEquals("anonymous", REQUEST_ID.orElse("anonymous"));
    }

    /**
     * 独立虚拟线程使用自己的作用域
     */
    @Test
    void keepsBindingLocalWhenSubmittingAnOrdinaryVirtualThreadTask() throws Exception {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            boolean childBound = ScopedValue.where(REQUEST_ID, "request-42")
                    .call(() -> executor.submit(REQUEST_ID::isBound).get(5, TimeUnit.SECONDS));

            assertFalse(childBound);
        }
    }
}
