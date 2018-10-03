package com.github.mikhailstepanov88.grpc_kotlin.internal.task.configurer

import org.gradle.api.Task

class CompileKotlinTaskConfigurer : TaskConfigurer() {
    /**
     * Get name of task for search in project.
     *
     * @return name of task for search in project.
     */
    override fun searchTaskName() = "compileKotlin"

    /**
     * Update task.
     */
    override fun Task.update() {
        dependsOn("generateProto")
    }
}