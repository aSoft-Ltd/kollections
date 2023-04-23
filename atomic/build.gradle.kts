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

//apply(plugin = "kotlinx-atomicfu")

description = "A Kotlin Multiplatform Mutable Collections that are thread safe"

kotlin {
    if (Targeting.JVM) jvm { library() }
    if (Targeting.JS) js(IR) { library() }
//    if (Targeting.WASM) wasm { library() }
    val osxTargets = if (Targeting.OSX) osxTargets() else listOf()
//    val ndkTargets = if (Targeting.NDK) ndkTargets() else listOf()
    val linuxTargets = if (Targeting.LINUX) linuxTargets() else listOf()
    val mingwTargets = if (Targeting.MINGW) mingwTargets() else listOf()

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(projects.kollectionsInteroperable)
                api(kotlinx.atomicfu)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(projects.kommanderCoroutines)
            }
        }
    }
}