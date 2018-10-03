package com.github.mikhailstepanov88.grpc_kotlin

import com.github.mikhailstepanov88.grpc_kotlin.internal.dependency.configurer.CompileDependenciesConfigurer
import com.github.mikhailstepanov88.grpc_kotlin.internal.dependency.configurer.CompileOnlyDependenciesConfigurer
import com.github.mikhailstepanov88.grpc_kotlin.internal.plugin.configurer.IdeaPluginConfigurer
import com.github.mikhailstepanov88.grpc_kotlin.internal.plugin.configurer.JavaPluginConfigurer
import com.github.mikhailstepanov88.grpc_kotlin.internal.plugin.configurer.KotlinPluginConfigurer
import com.github.mikhailstepanov88.grpc_kotlin.internal.plugin.configurer.ProtobufPluginConfigurer
import com.github.mikhailstepanov88.grpc_kotlin.internal.task.configurer.CompileKotlinTaskConfigurer
import org.gradle.api.Plugin
import org.gradle.api.Project

class GrpcKotlinPlugin : Plugin<Project> {
    private val pluginsConfigurers = listOf(
            IdeaPluginConfigurer(),
            JavaPluginConfigurer(),
            KotlinPluginConfigurer(),
            ProtobufPluginConfigurer())
    private val dependenciesConfigurers = listOf(
            CompileDependenciesConfigurer(),
            CompileOnlyDependenciesConfigurer())
    private val tasksConfigurers = listOf(
            CompileKotlinTaskConfigurer())

    /**
     * Apply this plugin to the given target object.
     *
     * @param target The target object.
     */
    override fun apply(target: Project) {
        pluginsConfigurers.forEach { it.configure(target) }
        dependenciesConfigurers.forEach { it.configure(target) }
        tasksConfigurers.forEach { it.configure(target) }
    }
}