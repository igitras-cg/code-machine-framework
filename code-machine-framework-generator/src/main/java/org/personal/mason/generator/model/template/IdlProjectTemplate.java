package org.personal.mason.generator.model.template;

import java.util.List;

public interface IdlProjectTemplate extends IdlTemplate {

    /**
     * Get all the file templates.
     *
     * @return file templates
     */
    List<IdlFileTemplate> getFileTemplates();
}
