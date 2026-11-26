package com.tynet;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StreamApiTest {

    /**
     * Stream 结果列表的可修改性
     */
    @Test
    void selectsTheCollectorWhenTheResultMustBeMutable() {
        // toList() 返回不可修改的列表
        List<String> languages = Stream.of("Java", "SQL", "Git").toList();
        assertEquals(List.of("Java", "SQL", "Git"), languages);
        assertThrows(UnsupportedOperationException.class, () -> languages.add("Kotlin"));

        List<String> editable = languages.stream().collect(Collectors.toCollection(ArrayList::new));
        editable.add("Kotlin");
        assertEquals(List.of("Java", "SQL", "Git", "Kotlin"), editable);
    }

    /**
     * 用 {@code mapMulti} 展开分组
     */
    @Test
    void emitsZeroOneOrManyValuesPerElement() {
        List<List<String>> groups = List.of(List.of("java", "maven"), List.of(), List.of("git"));
        List<String> tags = groups.stream()
                .<String>mapMulti((group, downstream) -> group.forEach(downstream))
                .toList();

        assertEquals(List.of("java", "maven", "git"), tags);
    }
}
