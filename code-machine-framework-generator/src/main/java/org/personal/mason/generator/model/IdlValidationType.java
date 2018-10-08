package org.personal.mason.generator.model;

public enum IdlValidationType {
    Required(false, false),
    Unique(false, false),
    MinimumLength(true, false),
    MaximumLength(true, false),
    Pattern(true, false),
    Minimum(true, true),
    Maximum(true, true);

    private final boolean requireParameter;
    private final boolean numericParameter;

    IdlValidationType(boolean required, boolean numeric) {
        this.requireParameter = required;
        this.numericParameter = numeric;
    }

    public boolean isRequireParameter() {
        return requireParameter;
    }

    public boolean isNumericParameter() {
        return numericParameter;
    }

}
