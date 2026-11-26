package com.tynet;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Gatherers;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StreamGatherersTest {

    /**
     * 分批时保留不足一组的元素
     */
    @Test
    void batchesElementsAndKeepsTheFinalPartialWindow() {
        List<List<Integer>> batches = Stream.of(1, 2, 3, 4, 5)
                .gather(Gatherers.windowFixed(2))
                .toList();

        assertEquals(List.of(List.of(1, 2), List.of(3, 4), List.of(5)), batches);
    }

    /**
     * 用 {@code scan} 逐项输出累计值
     */
    @Test
    void emitsTheRunningTotalAfterEachElement() {
        List<Integer> runningTotals = Stream.of(3, 1, 4)
                .gather(Gatherers.scan(() -> 0, Integer::sum))
                .toList();

        assertEquals(List.of(3, 4, 8), runningTotals);
    }
}
