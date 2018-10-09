package org.personal.mason.generator.model.project;

import java.io.File;

public interface IdlProject extends IdlModule {

    /**
     * Get the project type.
     *
     * @return project type
     */
    IdlProjectType getType();

    /**
     * Get the base directory.
     *
     * @return base directory.
     */
    File getBaseDir();



}
