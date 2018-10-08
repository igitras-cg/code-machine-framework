package org.personal.mason.generator.model;

import java.util.List;

/**
 * Idl Property.
 *
 * @author mason
 */
public interface IdlProperty {

    /**
     * Get the property name.
     *
     * @return property name
     */
    String getName();

    /**
     * Get the property type.
     *
     * @return property type
     */
    IdlPropertyType getType();

    /**
     * Get the property validations.
     *
     * @return property validations
     */
    List<IdlValidation> getValidations();
}
