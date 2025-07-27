

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("tz.co.asoft.library")
}

description = "A collection library that is built with interoperability in mind"

kotlin {
    if (Targeting.JVM) jvm { library() }
    if (Targeting.JS) js(IR) { library() }
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
                api(kotlinx.serialization.core)
                api(libs.kotlinx.exports)
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

            jvmTest.dependencies {
                implementation(kotlin("test-junit5"))
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



