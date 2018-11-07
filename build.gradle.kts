buildscript {
    repositories {
        mavenCentral()
        mavenLocal()
        jcenter()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.0")
        classpath("com.github.jengelman.gradle.plugins:shadow:4.0.2")
    }
}

plugins {
    `maven-publish`
    id("org.jetbrains.dokka") version "0.9.16"
    id("org.jetbrains.kotlin.multiplatform") version "1.3.0"
}

allprojects {
    group = "org.hexworks.mixite"
    version = "2018.0.4-PREVIEW"

    apply(plugin = "org.jetbrains.kotlin.multiplatform")

    repositories {
        mavenCentral()
        mavenLocal()
        jcenter()
        maven { url = uri("https://dl.bintray.com/kotlin/kotlinx") }
        maven { url = uri("https://jitpack.io") }
    }
}
