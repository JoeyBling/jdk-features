package com.tynet;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VirtualThreadTest {

    /**
     * 每个任务使用独立的虚拟线程
     */
    @Test
    void startsADistinctVirtualThreadForEachTask()
            throws InterruptedException, ExecutionException, TimeoutException {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            var first = executor.submit(Thread::currentThread);
            var second = executor.submit(Thread::currentThread);

            Thread firstThread = first.get(5, TimeUnit.SECONDS);
            Thread secondThread = second.get(5, TimeUnit.SECONDS);
            assertTrue(firstThread.isVirtual());
            assertTrue(secondThread.isVirtual());
            assertNotSame(firstThread, secondThread);
        }
    }
}
