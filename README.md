# Validation
Flexible validation library implemented with Java.

Latest version: [![](https://jitpack.io/v/codeerow/Validation.svg)](https://jitpack.io/#codeerow/Validation)

## Installation

Gradle is the only supported build configuration.

Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

```groovy
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```

Step 2. Add the dependency
```groovy
dependencies {
        implementation 'com.github.codeerow.validation:core:$version' // core-ktx for Kotlin
}
```
