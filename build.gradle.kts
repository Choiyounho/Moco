allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Android.Tools.Build.GRADLE)
        classpath(Kotlin.GRADLE_PLUGIN)
        classpath(Kotlin.KOTLIN_SERIALIZATION)
    }
}
