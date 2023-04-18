@Suppress("DSL_SCOPE_VIOLATION") plugins {
    alias(androidx.plugins.library) apply false
    alias(kotlinz.plugins.multiplatform) apply false
    alias(kotlinz.plugins.serialization) apply false
    alias(kotlinz.plugins.compose) apply false
    alias(asoft.plugins.library) apply false
    alias(petuska.plugins.root.npm.publish) apply false
    alias(kotlinz.plugins.dokka)
    alias(nexus.plugins.publish)
    alias(asoft.plugins.deploy)
}

repositories {
    publicRepos()
}

subprojects {
    apply(plugin = "org.jetbrains.dokka")
}

tasks.dokkaHtmlMultiModule {
    moduleName.set("Kollections")
    outputDirectory.set(rootDir.resolve("docs"))
    moduleVersion.set(asoft.versions.root.get())
    includes.from("ReadMe.md")
}

group = "tz.co.asoft"
version = asoft.versions.root.get()