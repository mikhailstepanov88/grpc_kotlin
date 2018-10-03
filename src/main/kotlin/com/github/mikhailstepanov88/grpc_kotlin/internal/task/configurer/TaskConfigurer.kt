package com.github.mikhailstepanov88.grpc_kotlin.internal.task.configurer

import com.github.mikhailstepanov88.grpc_kotlin.internal.ProjectConfigurer
import org.gradle.api.Project
import org.gradle.api.Task

abstract class TaskConfigurer : ProjectConfigurer {
    /**
     * Get name of task for search in project.
     *
     * @return name of task for search in project.
     */
    abstract fun searchTaskName(): String

    /**
     * Update task.
     */
    abstract fun Task.update()

    /**
     * Configure task.
     *
     * @param project project for update.
     */
    override fun configure(project: Project) {
        project.getTasksByName(searchTaskName(), true).firstOrNull()?.update()
    }
}