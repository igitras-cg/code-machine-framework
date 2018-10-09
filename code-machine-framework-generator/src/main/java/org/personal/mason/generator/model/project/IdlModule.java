package org.personal.mason.generator.model.project;

import java.io.File;

public interface IdlModule extends IdlModuleBase, IdlModuleHierarchy {

    /**
     * Get the project artifactId.
     *
     * @return artifactId
     */
    String getArtifactId();

    /**
     * Get the project groupId.
     *
     * @return groupId
     */
    String getGroupId();

    /**
     * Get the project version.
     *
     * @return version
     */
    String getVersion();

    /**
     * Get the packaging type.
     *
     * @return packaging type
     */
    IdlPackaging getPackaging();

    /**
     * Get the working directory.
     *
     * @return working directory
     */
    File getWorkingDir();

}
