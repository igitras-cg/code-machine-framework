package org.personal.mason.generator.model.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class IdlEnumTest {

    @Test
    public void builder() {
        IdlEnum.IdlEnumBuilder builder = IdlEnum.builder();
        builder.withName("Enum1")
                .withElements("Element1")
                .withElements("Element1", "Element2");
        IdlEnum build = builder.build();
        assertEquals("Enum1", build.getName());
        assertEquals(2, build.getEnums().size());
        assertTrue(build.getEnums().contains("Element1"));
        assertTrue(build.getEnums().contains("Element2"));
    }
}