package org.personal.mason.generator.model.domain;

import org.personal.mason.generator.model.IdlNameable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Idl Model.
 *
 * @author mason
 */
public interface IdlModel extends IdlNameable {

    /**
     * Get all the properties.
     *
     * @return properties
     */
    List<IdlProperty> getProperties();

    static IdlModelBuilder builder() {
        return new IdlModelBuilder();
    }

    class IdlModelBuilder {

        private String name;
        private List<IdlProperty> properties = new ArrayList<>();

        public IdlModelBuilder withName(final String name) {
            this.name = name;
            return this;
        }

        public IdlModelBuilder withProperties(final IdlProperty... properties) {
            Stream.of(properties).forEachOrdered(property -> {
                if (this.properties.stream().noneMatch(p -> p.getName().equals(property.getName()))) {
                    this.properties.add(property);
                }
            });
            return this;
        }

        IdlModel build() {
            return new IdlModel() {
                @Override
                public List<IdlProperty> getProperties() {
                    return IdlModelBuilder.this.properties;
                }

                @Override
                public String getName() {
                    return IdlModelBuilder.this.name;
                }

            };
        }
    }
}
