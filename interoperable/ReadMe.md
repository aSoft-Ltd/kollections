# Kollections

An abstractions of kollections that are easily interoperable with Javascript/Typescript and swift

![Maven](https://img.shields.io/maven-central/v/tz.co.asoft/kollections-interoperable/2.0.13?style=for-the-badge)
![Kotlin](https://img.shields.io/badge/kotlin-multiplatform-blue?style=for-the-badge&logo=kotlin&logoColor=white)
![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=&logoColor=white)
![Swift](https://img.shields.io/badge/swift-F54A2A?style=for-the-badge&logo=swift&logoColor=white)
![iOS](https://img.shields.io/badge/iOS-000000?style=for-the-badge&logo=ios&logoColor=white)
![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E)
![TypeScript](https://img.shields.io/badge/typescript-%23007ACC.svg?style=for-the-badge&logo=typescript&logoColor=white)

## Setup: Gradle

```kotlin
dependencies {
    implementation("tz.co.asoft:kollections-interoperable:2.0.13")
    // - - - - - or - - - - - 
    implementation("tz.co.asoft:kollections-atomic:2.0.13")
}
```

## Nullability
```kotlin
val name: String? = null
expect(name).toBeNull()

val age: Int = 0
expect(age).toBeNonNull()
```

## Custom Assertions
You can create your custom assertions easily in kotlin as well

[//]: # ([inject]&#40;../core/src/commonTest/kotlin/samples/CustomAssertionsTest.kt&#41;)

## Api Reference
The full api reference of the kolletions can be found at [https://asoft-ltd.github.io/kollections](https://asoft-ltd.github.io/kollections)


## Support

There are multiple ways you can support this project

### Star It

If you found it useful, just give it a star

### Contribute

You can help by submitting pull request to available open tickets on the issues section

### Report Issues

This makes it easier to catch bugs and offer enhancements required

## Credits

- [andylamax](https://github.com/andylamax) - The author