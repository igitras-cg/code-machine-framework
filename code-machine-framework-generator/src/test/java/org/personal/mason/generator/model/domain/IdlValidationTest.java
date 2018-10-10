package org.personal.mason.generator.model.domain;

import org.junit.Test;
import org.personal.mason.generator.InvalidOperationException;

import static org.junit.Assert.*;

public class IdlValidationTest {

    @Test(expected = InvalidOperationException.class)
    public void builder() {
        boolean normalInvokeFlag;
        try {
            IdlValidation.builder().withType(IdlValidationType.Required).withParameter("").build();
            normalInvokeFlag = true;
        } catch (InvalidOperationException e) {
            normalInvokeFlag = false;
        }
        assertFalse(normalInvokeFlag);

        try {
            IdlValidation.builder().withParameter("");
            normalInvokeFlag = true;
        } catch (RuntimeException e) {
            normalInvokeFlag = false;
        }
        assertFalse(normalInvokeFlag);

        IdlValidation build = IdlValidation.builder()
                .withType(IdlValidationType.Pattern)
                .withParameter("Test.*")
                .build();
        assertEquals(IdlValidationType.Pattern, build.getType());
        assertEquals("Test.*", build.getParameter());

        build = IdlValidation.builder()
                .withType(IdlValidationType.Required)
                .build();
        assertEquals(IdlValidationType.Required, build.getType());
        build.getParameter();
    }
}