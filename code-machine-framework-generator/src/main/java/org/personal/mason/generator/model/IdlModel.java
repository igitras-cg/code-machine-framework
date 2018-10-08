package org.personal.mason.generator.model;

import java.util.List;

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
}
