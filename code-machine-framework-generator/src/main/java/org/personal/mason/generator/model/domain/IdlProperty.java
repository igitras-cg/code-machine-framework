package org.personal.mason.generator.model.domain;

import org.personal.mason.generator.InvalidOperationException;
import org.personal.mason.generator.model.IdlNameable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.String.format;

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

    static IdlPropertyBuilder builder() {
        return new IdlPropertyBuilder();
    }

    class IdlPropertyBuilder {
        private String name;
        private List<IdlValidation> validations = new ArrayList<>();
        private IdlEnum enumeration;
        private IdlPropertyType type;

        public IdlPropertyBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public IdlPropertyBuilder withType(IdlPropertyType type) {
            this.type = type;
            return this;
        }

        public IdlPropertyBuilder withEnum(IdlEnum enumeration) {
            this.type = IdlPropertyType.IdlEnum;
            this.enumeration = enumeration;
            return this;
        }

        public IdlPropertyBuilder withValidations(final IdlValidation... validations) {
            if (this.type == null) {
                throw new InvalidOperationException("Should setting IdlPropertyType first");
            }

            Stream.of(validations)
                    .filter(validation -> type.availableValidationTypes().contains(validation.getType()))
                    .forEachOrdered(validation -> {
                        if (this.validations.stream().noneMatch(v -> v.getType().equals(validation.getType()))) {
                            this.validations.add(validation);
                        }
                    });
            return this;
        }

        IdlProperty build() {
            return new IdlProperty() {
                @Override
                public IdlPropertyType getType() {
                    return IdlPropertyBuilder.this.type;
                }

                @Override
                public IdlEnum getEnum() {
                    return isEnum() ? IdlPropertyBuilder.this.enumeration : null;
                }

                @Override
                public List<IdlValidation> getValidations() {
                    return IdlPropertyBuilder.this.validations;
                }

                @Override
                public String getName() {
                    return IdlPropertyBuilder.this.name;
                }
            };
        }
    }
}
