package com.github.mikhailstepanov88.grpc_kotlin.internal.plugin.configurer

import org.gradle.api.Project
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.plugins.JavaPluginConvention
import java.io.File

class JavaPluginConfigurer : PluginConfigurer<JavaPluginConvention>() {
    /**
     * Get class of plugin for search in project.
     *
     * @return class of plugin for search in project.
     */
    override fun searchPluginClass() = JavaPlugin::class.java

    /**
     * Get class of plugin for add to project.
     *
     * @return class of plugin for add to project.
     */
    override fun pluginClass() = JavaPlugin::class.java

    /**
     * Is plugin will be added to project if it not exists.
     *
     * @return plugin will be added to project if it not exists or not.
     */
    override fun addPluginIfNotExists() = false

    /**
     * Get configuration of plugin.
     *
     * @param project project.
     * @return configuration of plugin.
     */
    override fun pluginConfig(project: Project) =
            project.convention.getPlugin(JavaPluginConvention::class.java)

    /**
     * Update configuration of plugin.
     */
    override fun JavaPluginConvention.update() {
        val mainSourceSets = sourceSets.getByName("main").java
        mainSourceSets.setSrcDirs(mainSourceSets.srcDirs +
                File("build/generated/source/proto/main/grpc") +
                File("build/generated/source/proto/main/java"))
    }
}