package com.github.mikhailstepanov88.grpc_kotlin.internal.plugin.configurer

import com.github.mikhailstepanov88.grpc_kotlin.internal.ProjectConfigurer
import org.gradle.api.Plugin
import org.gradle.api.Project

abstract class PluginConfigurer<TypeOfConfig> : ProjectConfigurer {
    /**
     * Get class of plugin for search in project.
     *
     * @return class of plugin for search in project.
     */
    abstract fun searchPluginClass(): Class<out Plugin<out Project>>

    /**
     * Get class of plugin for add to project.
     *
     * @return class of plugin for add to project.
     */
    abstract fun pluginClass(): Class<out Plugin<out Project>>

    /**
     * Is plugin will be added to project if it not exists.
     *
     * @return plugin will be added to project if it not exists or not.
     */
    abstract fun addPluginIfNotExists(): Boolean

    /**
     * Get configuration of plugin.
     *
     * @param project project.
     * @return configuration of plugin.
     */
    abstract fun pluginConfig(project: Project): TypeOfConfig

    /**
     * Update configuration of plugin.
     */
    abstract fun TypeOfConfig.update()

    /**
     * Configurate plugin.
     *
     * @param project project for update.
     */
    override fun configure(project: Project) {
        if (!project.plugins.hasPlugin(searchPluginClass()))
            project.plugins.apply(pluginClass())
        pluginConfig(project).update()
    }
}