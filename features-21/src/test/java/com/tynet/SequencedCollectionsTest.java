package com.tynet;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SequencedCollection;
import java.util.SequencedMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SequencedCollectionsTest {

    /**
     * 反向视图与原列表共享数据
     */
    @Test
    void changesTheBackingListThroughItsReversedView() {
        List<String> history = new ArrayList<>(List.of("created", "paid"));
        SequencedCollection<String> latestFirst = history.reversed();

        assertEquals("paid", latestFirst.getFirst());
        assertEquals("created", latestFirst.getLast());

        latestFirst.addFirst("shipped");
        assertEquals(List.of("created", "paid", "shipped"), history);

        history.addLast("delivered");
        assertEquals("delivered", latestFirst.getFirst());
    }

    /**
     * 有序 Map 的首尾访问与重排
     */
    @Test
    void controlsEncounterOrderInASequencedMap() {
        SequencedMap<String, Integer> priorities = new LinkedHashMap<>();
        priorities.putLast("normal", 2);
        priorities.putLast("low", 3);
        priorities.putFirst("urgent", 1);

        assertEquals(Map.entry("urgent", 1), priorities.firstEntry());
        assertEquals(Map.entry("low", 3), priorities.lastEntry());
        assertEquals(List.of("low", "normal", "urgent"), List.copyOf(priorities.reversed().sequencedKeySet()));

        priorities.putLast("urgent", 1);
        assertEquals(List.of("normal", "low", "urgent"), List.copyOf(priorities.sequencedKeySet()));
    }
}
