package com.github.mikhailstepanov88.grpc_kotlin.internal.dependency.configurer

import org.gradle.api.Project

class CompileDependenciesConfigurer : DependenciesConfigurer() {
    private val dependencies = listOf(Triple("org.jetbrains.kotlin", "kotlin-stdlib-jdk8", null))

    /**
     * Configure dependencies.
     *
     * @param project project for update.
     */
    override fun configure(project: Project) {
        dependencies.forEach {
            val (group, name, version) = it
            project.dependencies.add("compile", dependencyNotation(group, name, version))
        }
    }
}