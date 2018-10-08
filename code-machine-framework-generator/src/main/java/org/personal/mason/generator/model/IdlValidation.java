package org.personal.mason.generator.model;

/**
 * IdlValidation.
 *
 * @author mason
 */
public interface IdlValidation {

    /**
     * Get the validation type.
     *
     * @return validation type
     */
    IdlValidationType getType();

    /**
     * Get the parameter in text.
     *
     * @return patameter
     */
    String getParameter();

    default boolean isRequireParameter() {
        return getType().isRequireParameter();
    }

    default boolean isNumericParameter() {
        return getType().isNumericParameter();
    }
}
