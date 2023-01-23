# Mutable Atomic Collections

![badge][badge-maven] ![badge][badge-mpp] ![badge][badge-android] ![badge][badge-js] ![badge][badge-jvm] ![badge][badge-ios]

## Introduction

To avoid mutability exceptions, we are currently using this as underlying tool to work around mutable lists when
crossing threads

## Setup : Gradle

```kotlin
dependencies {
    implementation("tz.co.asoft:kotlinx-atomic-collections:0.0.10")
}
```

## Samples

```kotlin
val list: MutableList<Int> = mutableAtomicListOf(1)
```

[badge-maven]: https://img.shields.io/maven-central/v/tz.co.asoft/kotlinx-atomic-collections/0.0.10?style=flat

[badge-mpp]: https://img.shields.io/badge/kotlin-multiplatform-blue?style=flat

[badge-android]: http://img.shields.io/badge/platform-android-brightgreen.svg?style=flat

[badge-js]: http://img.shields.io/badge/platform-js-yellow.svg?style=flat

[badge-jvm]: http://img.shields.io/badge/platform-jvm-orange.svg?style=flat

[badge-ios]: http://img.shields.io/badge/platform-ios-silver.svg?style=flat
