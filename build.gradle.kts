version = "0.1"
group = "com.github.mikhailstepanov88"

buildscript {
    repositories {
        jcenter()
    }
}

plugins {
    id("java-gradle-plugin")
    id("org.jetbrains.kotlin.jvm").version("1.2.71")
    id("com.gradle.plugin-publish").version("0.10.0")
}

repositories {
    jcenter()
}

dependencies {
    compile(group = "org.jetbrains.kotlin", name = "kotlin-stdlib-jdk8")
    compile(group = "org.jetbrains.kotlin", name = "kotlin-gradle-plugin", version = "1.2.71")
    compile(group = "com.google.protobuf", name = "protobuf-gradle-plugin", version = "0.8.6")
}

pluginBundle {
    tags = listOf("kotlin", "grpc")
    vcsUrl = "https://github.com/mikhailstepanov88/grpc_kotlin"
    website = "https://github.com/mikhailstepanov88/grpc_kotlin"
    description = "Plugin for simplify working with GRPC and kotlin"
}

gradlePlugin {
    plugins {
        create("grpcKotlinPlugin") {
            id = "com.github.mikhailstepanov88.grpc-kotlin"
            displayName = "GRPC Kotlin Plugin"
            description = "Plugin for simplify working with GRPC and kotlin"
            implementationClass = "com.github.mikhailstepanov88.grpc_kotlin.GrpcKotlinPlugin"
        }
    }
}