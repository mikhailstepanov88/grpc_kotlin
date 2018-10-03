package com.github.mikhailstepanov88.grpc_kotlin.internal.dependency.configurer

import org.gradle.api.Project

class CompileOnlyDependenciesConfigurer : DependenciesConfigurer() {
    private val dependencies = listOf(Triple("com.google.api.grpc", "proto-google-common-protos", "1.12.0"))

    /**
     * Configure dependencies.
     *
     * @param project project for update.
     */
    override fun configure(project: Project) {
        dependencies.forEach {
            val (group, name, version) = it
            project.dependencies.add("compileOnly", dependencyNotation(group, name, version))
        }
    }
}