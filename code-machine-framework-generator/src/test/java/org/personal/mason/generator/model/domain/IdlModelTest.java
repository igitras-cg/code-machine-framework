package org.personal.mason.generator.model.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class IdlModelTest {

    @Test
    public void builder() {
        IdlModel build = IdlModel.builder()
                .withName("IdlModel")
                .withProperties(
                        IdlProperty.builder().withName("field1").withType(IdlPropertyType.String).withValidations(
                                IdlValidation.builder().withType(IdlValidationType.Required).build()
                        ).build(),
                        IdlProperty.builder().withName("field2").withType(IdlPropertyType.Boolean).withValidations(
                                IdlValidation.builder().withType(IdlValidationType.Required).build()
                        ).build(),
                        IdlProperty.builder().withName("field3").withType(IdlPropertyType.BigDecimal).withValidations(
                                IdlValidation.builder().withType(IdlValidationType.Maximum).withParameter("9.0").build()
                        ).build()
                )
                .build();

        assertEquals(3, build.getProperties().size());
        assertTrue(build.getProperties().stream().anyMatch(p -> p.getName().equals("field1")));
        assertTrue(build.getProperties().stream().anyMatch(p -> p.getName().equals("field2")));
        assertTrue(build.getProperties().stream().anyMatch(p -> p.getName().equals("field3")));

        build = IdlModel.builder()
                .withName("IdlModel")
                .withProperties(
                        IdlProperty.builder().withName("field1").withType(IdlPropertyType.String).withValidations(
                                IdlValidation.builder().withType(IdlValidationType.Required).build()
                        ).build(),
                        IdlProperty.builder().withName("field2").withType(IdlPropertyType.Boolean).withValidations(
                                IdlValidation.builder().withType(IdlValidationType.Required).build()
                        ).build(),
                        IdlProperty.builder().withName("field2").withType(IdlPropertyType.BigDecimal).withValidations(
                                IdlValidation.builder().withType(IdlValidationType.Maximum).withParameter("9.0").build()
                        ).build()
                )
                .build();
        assertTrue(build.getProperties().stream().anyMatch(p -> p.getName().equals("field1")));
        assertTrue(build.getProperties().stream().anyMatch(p -> p.getName().equals("field2")));
        assertTrue(build.getProperties().stream().noneMatch(p -> p.getName().equals("field3")));
    }
}