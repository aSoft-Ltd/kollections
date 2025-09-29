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
    id("org.jetbrains.kotlinx.atomicfu")
    id("tz.co.asoft.library")
    signing
}

description = "A Kotlin Multiplatform Mutable Collections that are thread safe"

kotlin {
    if (Targeting.JVM) jvm { library() }
    if (Targeting.JS) js(IR) { library() } //
    if (Targeting.WASM) wasmJs { library() }
    if (Targeting.WASM) wasmWasi { library() }
    val osxTargets = if (Targeting.OSX) osxTargets() else listOf()
    val ndkTargets = if (Targeting.NDK) ndkTargets() else listOf()
    val linuxTargets = if (Targeting.LINUX) linuxTargets() else listOf()
    val mingwTargets = if (Targeting.MINGW) mingwTargets() else listOf()
    val nativeTargets = osxTargets + ndkTargets + linuxTargets + mingwTargets

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(projects.kollectionsPrimitive)
                api(kotlinx.atomicfu)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlinx.serialization.json)
                implementation(libs.kommander.core)
            }
        }

        val nonJsMain by creating {
            dependsOn(commonMain)
        }

        if (Targeting.JVM) {
            val jvmMain by getting {
                dependsOn(nonJsMain)
            }
        }

        if (Targeting.WASM) {
            val wasmJsMain by getting {
                dependsOn(nonJsMain)
            }

            val wasmWasiMain by getting {
                dependsOn(nonJsMain)
            }
        }

        nativeTargets.forEach {
            val main by it.compilations.getting {}
            main.defaultSourceSet {
                dependsOn(nonJsMain)
            }
        }
    }
}