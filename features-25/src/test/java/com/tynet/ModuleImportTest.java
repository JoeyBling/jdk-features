package com.tynet;

import module java.base;
import module java.sql;

import org.junit.jupiter.api.Test;

// 单类型导入优先，选择 java.sql.Date
import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ModuleImportTest {

    /**
     * 模块导入中的同名类型
     */
    @Test
    void resolvesAnAmbiguousSimpleNameWithAnExplicitImport() {
        LocalDate publicationDate = LocalDate.of(2025, 9, 16);
        List<Date> dates = List.of(Date.valueOf(publicationDate));

        assertEquals(publicationDate, dates.getFirst().toLocalDate());
    }
}
