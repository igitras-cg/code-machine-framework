package org.personal.mason.generator.model;

import java.util.Set;

import static org.personal.mason.generator.model.IdlValidationType.*;

public enum IdlPropertyType {
    String {
        @Override
        public Set<IdlValidationType> availableValidationTypes() {
            return Set.of(Required, Unique, MaximumLength, MinimumLength, Pattern);
        }
    },
    Integer {
        @Override
        public Set<IdlValidationType> availableValidationTypes() {
            return Set.of(Required, Unique, Maximum, Minimum);
        }
    },
    Long {
        @Override
        public Set<IdlValidationType> availableValidationTypes() {
            return Set.of(Required, Unique, Maximum, Minimum);
        }
    },
    Float {
        @Override
        public Set<IdlValidationType> availableValidationTypes() {
            return Set.of(Required, Unique, Maximum, Minimum);
        }
    },
    Double {
        @Override
        public Set<IdlValidationType> availableValidationTypes() {
            return Set.of(Required, Unique, Maximum, Minimum);
        }
    },
    BigDecimal {
        @Override
        public Set<IdlValidationType> availableValidationTypes() {
            return Set.of(Required, Unique, Maximum, Minimum);
        }
    },
    LocalDate {
        @Override
        public Set<IdlValidationType> availableValidationTypes() {
            return Set.of(Required, Unique);
        }
    },
    Instant {
        @Override
        public Set<IdlValidationType> availableValidationTypes() {
            return Set.of(Required, Unique);
        }
    },
    ZonedDateTime {
        @Override
        public Set<IdlValidationType> availableValidationTypes() {
            return Set.of(Required, Unique);
        }
    },
    Boolean {
        @Override
        public Set<IdlValidationType> availableValidationTypes() {
            return Set.of(Required, Unique);
        }
    },
    IdlEnum {
        @Override
        public Set<IdlValidationType> availableValidationTypes() {
            return Set.of(Required);
        }
    };

    public abstract Set<IdlValidationType> availableValidationTypes();
}
