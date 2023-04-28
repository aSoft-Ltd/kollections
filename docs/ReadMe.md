# Kollections

An abstractions of kollections that are easily interoperable with Javascript/Typescript and swift

[badges]

## Sample
```kotlin
import kollections.List
import kollections.Map
import kollections.Set

val numberSet = iSetOf(1, 2, 3, 4, 5) // Interoperable set of
val numberList = iListOf(1, 2, 3, 4, 5) // Interoperable list of
val numberMap = iMapOf(1 to "one", 2 to "two")
```

## Setup: Gradle

```kotlin
dependencies {
    implementation("tz.co.asoft:kollections-interoperable:[version]")
    // - - - - - or - - - - - 
    implementation("tz.co.asoft:kollections-atomic:[version]")
}
```

## Api Reference
The full api reference of the kollections can be found at [https://asoft-ltd.github.io/kollections](https://asoft-ltd.github.io/kollections)


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