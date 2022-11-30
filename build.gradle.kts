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
	mavenLocal()
	maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

val tmp = 0
allprojects {
    beforeEvaluate {
        repositories {
            publicRepos()
            mavenLocal()
		    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        }
        group = "tz.co.asoft"
        version = "0.0.0"
    }
}