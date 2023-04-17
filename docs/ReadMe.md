# Kollections

An abstractions of kollections that are easily interoperable with Javascript/Typescript and swift

[badges]

## Setup: Gradle

```kotlin
dependencies {
    implementation("tz.co.asoft:kollections-interoperable:[version]")
    // - - - - - or - - - - - 
    implementation("tz.co.asoft:kollections-atomic:[version]")
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