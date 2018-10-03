package com.github.mikhailstepanov88.grpc_kotlin.internal.plugin.configurer

import org.gradle.api.Project
import org.gradle.plugins.ide.idea.IdeaPlugin
import org.gradle.plugins.ide.idea.model.IdeaModel
import java.io.File

class IdeaPluginConfigurer : PluginConfigurer<IdeaModel>() {
    /**
     * Get class of plugin for search in project.
     *
     * @return class of plugin for search in project.
     */
    override fun searchPluginClass() = IdeaPlugin::class.java

    /**
     * Get class of plugin for add to project.
     *
     * @return class of plugin for add to project.
     */
    override fun pluginClass() = IdeaPlugin::class.java

    /**
     * Is plugin will be added to project if it not exists.
     *
     * @return plugin will be added to project if it not exists or not.
     */
    override fun addPluginIfNotExists() = true

    /**
     * Get configuration of plugin.
     *
     * @param project project.
     * @return configuration of plugin.
     */
    override fun pluginConfig(project: Project) =
            project.extensions.getByType(IdeaModel::class.java)

    /**
     * Update configuration of plugin.
     */
    override fun IdeaModel.update() {
        module.sourceDirs = module.sourceDirs +
                File("build/generated/source/proto/main/grpc") +
                File("build/generated/source/proto/main/java")
    }
}