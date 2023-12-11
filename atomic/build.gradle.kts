import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension
import org.jetbrains.kotlin.gradle.targets.js.npm.tasks.KotlinNpmInstallTask

buildscript {
    repositories {
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.kotlinx:atomicfu-gradle-plugin:${kotlinx.versions.atomicfu.get()}")
    }
}

plugins {
    kotlin("multiplatform")
    id("tz.co.asoft.library")
    signing
}

apply(plugin = "kotlinx-atomicfu")

description = "A Kotlin Multiplatform Mutable Collections that are thread safe"

kotlin {
    if (Targeting.JVM) jvm { library() }
    if (Targeting.JS) js(IR) { library() }
    if (Targeting.WASM) wasmJs { library() }
    if (Targeting.WASM) wasmWasi { library() }
    val osxTargets = if (Targeting.OSX) osxTargets() else listOf()
//    val ndkTargets = if (Targeting.NDK) ndkTargets() else listOf()
    val linuxTargets = if (Targeting.LINUX) linuxTargets() else listOf()
    val mingwTargets = if (Targeting.MINGW) mingwTargets() else listOf()

    sourceSets {
        commonMain.dependencies {
            api(projects.kollectionsInteroperable)
            api(kotlinx.atomicfu)
        }

        commonTest.dependencies {
            implementation(libs.kommander.core)
        }
    }
}

rootProject.the<NodeJsRootExtension>().apply {
    nodeVersion = npm.versions.node.version.get()
    nodeDownloadBaseUrl = npm.versions.node.url.get()
}

rootProject.tasks.withType<KotlinNpmInstallTask>().configureEach {
    args.add("--ignore-engines")
}

tasks.named("wasmJsTestTestDevelopmentExecutableCompileSync").configure {
    mustRunAfter(tasks.named("jsBrowserTest"))
    mustRunAfter(tasks.named("jsNodeTest"))
}