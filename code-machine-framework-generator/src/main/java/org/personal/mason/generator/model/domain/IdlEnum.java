package org.personal.mason.generator.model.domain;

import org.personal.mason.generator.model.IdlNameable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Idl Enum.
 *
 * @author mason
 */
public interface IdlEnum extends IdlNameable {

    /**
     * Get the enums.
     *
     * @return enums
     */
    List<String> getEnums();

    /**
     * Create an IdlEnum Builder.
     *
     * @return IdlEnumBuilder
     */
    static IdlEnumBuilder builder() {
        return new IdlEnumBuilder();
    }

    class IdlEnumBuilder {
        private String name;
        private List<String> enums = new ArrayList<>();

        private IdlEnumBuilder() {
        }

        public IdlEnumBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public IdlEnumBuilder withElements(final String... elements) {
            Stream.of(elements).forEachOrdered(element -> {
                if (!this.enums.contains(element)) {
                    this.enums.add(element);
                }
            });
            return this;
        }

        public IdlEnum build() {
            return new IdlEnum() {
                @Override
                public List<String> getEnums() {
                    return IdlEnumBuilder.this.enums;
                }

                @Override
                public String getName() {
                    return IdlEnumBuilder.this.name;
                }
            };
        }
    }
}
