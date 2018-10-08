package org.personal.mason.generator.model;

import java.util.List;

/**
 * Idl Property.
 *
 * @author mason
 */
public interface IdlProperty extends IdlNameable {


    /**
     * Get the property type.
     *
     * @return property type
     */
    IdlPropertyType getType();

    /**
     * Get the Enum model.
     *
     * @return enum model
     */
    IdlEnum getEnum();

    /**
     * Get the property validations.
     *
     * @return property validations
     */
    List<IdlValidation> getValidations();

    /**
     * Check if the property is reference to an enum.
     *
     * @return is enum
     */
    default boolean isEnum() {
        return IdlPropertyType.IdlEnum.equals(getType());
    }
}
