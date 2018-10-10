package org.personal.mason.generator.model.domain;

import org.personal.mason.generator.InvalidOperationException;

import static java.lang.String.format;

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

    static IdlValidationBuilder builder() {
        return new IdlValidationBuilder();
    }

    class IdlValidationBuilder {
        private IdlValidationType type;
        private String parameter;

        public IdlValidationBuilder withType(IdlValidationType type) {
            this.type = type;
            return this;
        }

        public IdlValidationBuilder withParameter(String parameter) {
            if (this.type == null) {
                throw new InvalidOperationException("Should setting IdlValidationType first");
            }

            if (!this.type.isRequireParameter()) {
                throw new InvalidOperationException(format("No parameter required for %s IdlValidation", type));
            }

            this.parameter = parameter;
            return this;
        }

        public IdlValidation build() {
            return new IdlValidation() {
                @Override
                public IdlValidationType getType() {
                    return IdlValidationBuilder.this.type;
                }

                @Override
                public String getParameter() {
                    if (isRequireParameter()) {
                        return IdlValidationBuilder.this.parameter;
                    }
                    throw new InvalidOperationException(format("No parameter for %s IdlValidation", getType()));
                }
            };
        }
    }
}
