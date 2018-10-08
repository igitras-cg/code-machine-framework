package org.personal.mason.generator.model;

import java.util.List;

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
}
