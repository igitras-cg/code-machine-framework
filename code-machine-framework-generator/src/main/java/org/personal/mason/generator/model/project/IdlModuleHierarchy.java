package org.personal.mason.generator.model.project;

import java.util.Set;

public interface IdlModuleHierarchy {

    /**
     * Get the parent module.
     *
     * @return parent module
     */
    IdlParentModule getParentModule();

    /**
     * Get the directly modules.
     *
     * @return directly modules
     */
    Set<IdlModule> getDirectModules();

    /**
     * Get all the modules.
     *
     * @return all the modules
     */
    Set<IdlModule> getAllModules();
}
