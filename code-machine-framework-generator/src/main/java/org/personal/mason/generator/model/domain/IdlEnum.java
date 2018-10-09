package org.personal.mason.generator.model.domain;

import org.personal.mason.generator.model.IdlNameable;

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
