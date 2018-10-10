package org.personal.mason.generator.model.domain;

import org.junit.Test;
import org.personal.mason.generator.InvalidOperationException;

import static org.junit.Assert.*;

public class IdlPropertyTest {

    @Test
    public void builder() {

        boolean normalInvokeFlag;
        try {
            IdlProperty.builder().withValidations();
            normalInvokeFlag = true;
        } catch (InvalidOperationException e) {
            normalInvokeFlag = false;
        }
        assertFalse(normalInvokeFlag);


        IdlProperty build = IdlProperty.builder()
                .withName("field1")
                .withType(IdlPropertyType.String)
                .withValidations(
                        IdlValidation.builder().withType(IdlValidationType.Required).build(),
                        IdlValidation.builder().withType(IdlValidationType.Pattern).withParameter("Test.*").build(),
                        IdlValidation.builder().withType(IdlValidationType.Maximum).withParameter("10").build())
                .build();
        assertNull(build.getEnum());
        assertEquals("field1", build.getName());
        assertEquals(2, build.getValidations().size());
        assertTrue(build.getValidations().stream().anyMatch(v -> v.getType().isRequireParameter()));
        assertTrue(build.getValidations().stream().noneMatch(v -> v.getType().isNumericParameter()));
        assertEquals(IdlPropertyType.String, build.getType());

        build = IdlProperty.builder()
                .withName("field2")
                .withEnum(IdlEnum.builder().withName("IdlEnum").withElements("First", "Second").build())
                .build();
        assertEquals("field2", build.getName());
        assertEquals(IdlPropertyType.IdlEnum, build.getType());
    }
}