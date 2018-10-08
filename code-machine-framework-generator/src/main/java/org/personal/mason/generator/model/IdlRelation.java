package org.personal.mason.generator.model;

public interface IdlRelation {

    /**
     * Get the relation ship type.
     *
     * @return relation ship type
     */
    IdlRelationType getType();

    /**
     * Get the from model.
     *
     * @return from model
     */
    IdlModel getFrom();

    /**
     * Get the from model relation ship name
     *
     * @return from relation ship name
     */
    String getFromRelationName();

    /**
     * Get the from relation ship display property.
     *
     * @return from relation ship display property
     */
    String getFromRelationDisplayProperty();

    /**
     * Get the to model.
     *
     * @return to model
     */
    IdlModel getTo();

    /**
     * Get the to relation ship name.
     *
     * @return to relation ship name
     */
    String getToRelationName();

    /**
     * Get the to relation ship display property.
     *
     * @return to relation ship display property
     */
    String getToRelationDisplayProperty();
}
