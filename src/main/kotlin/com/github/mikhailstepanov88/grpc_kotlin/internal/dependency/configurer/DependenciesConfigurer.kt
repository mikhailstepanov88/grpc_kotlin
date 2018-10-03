package com.github.mikhailstepanov88.grpc_kotlin.internal.dependency.configurer

import com.github.mikhailstepanov88.grpc_kotlin.internal.ProjectConfigurer
import org.gradle.api.Project

abstract class DependenciesConfigurer : ProjectConfigurer {
    /**
     * Configure dependencies.
     *
     * @param project project for update.
     */
    abstract override fun configure(project: Project)

    /**
     * Get notation of dependency.
     *
     * @param group   group of dependency.
     * @param name    name of dependency.
     * @param version version of dependency.
     * @return notation of dependency.
     */
    protected fun dependencyNotation(group: String?, name: String?, version: String?): Map<String, String> {
        val result = mutableMapOf<String, String>()
        name?.let { result.put("name", name) }
        group?.let { result.put("group", group) }
        version?.let { result.put("version", version) }
        return result
    }
}