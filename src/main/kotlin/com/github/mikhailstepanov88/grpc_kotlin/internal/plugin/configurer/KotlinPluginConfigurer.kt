package com.github.mikhailstepanov88.grpc_kotlin.internal.plugin.configurer

import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformJvmPlugin
import org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapper

class KotlinPluginConfigurer : PluginConfigurer<KotlinJvmProjectExtension>() {
    /**
     * Get class of plugin for search in project.
     *
     * @return class of plugin for search in project.
     */
    override fun searchPluginClass() = KotlinPluginWrapper::class.java

    /**
     * Get class of plugin for add to project.
     *
     * @return class of plugin for add to project.
     */
    override fun pluginClass() = KotlinPlatformJvmPlugin::class.java

    /**
     * Is plugin will be added to project if it not exists.
     *
     * @return add plugin to project if it not exists or not.
     */
    override fun addPluginIfNotExists() = true

    /**
     * Get configuration of plugin.
     *
     * @param project project.
     * @return configuration of plugin.
     */
    override fun pluginConfig(project: Project) =
            project.extensions.getByType(KotlinJvmProjectExtension::class.java)

    /**
     * Update configuration of plugin.
     */
    override fun KotlinJvmProjectExtension.update() {}
}