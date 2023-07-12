allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
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
    }
}
