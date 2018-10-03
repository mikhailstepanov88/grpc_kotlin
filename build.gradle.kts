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
}

repositories {
    jcenter()
}

dependencies {
    compile(group = "org.jetbrains.kotlin", name = "kotlin-stdlib-jdk8")
    compile(group = "org.jetbrains.kotlin", name = "kotlin-gradle-plugin", version = "1.2.71")
    compile(group = "com.google.protobuf", name = "protobuf-gradle-plugin", version = "0.8.6")
}