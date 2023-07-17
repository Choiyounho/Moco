import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id(Plugin.Android_Application)
    id(Plugin.JETBRAINS_KOTLIN_ANDROID)
    id(Plugin.DAGGER_HILT)
    kotlin(Plugin.KAPT)
    id(Plugin.KOTLINX_SERIALIZATION)

}

android {
    namespace = Project.NAME_SPACE
    compileSdk = Project.COMPILE_SDK

    defaultConfig {
        applicationId = Project.NAME_SPACE
        minSdk = Project.MIN_SDK
        targetSdk = Project.TARGET_SDK
        versionCode = Project.VERSION_CODE
        versionName = Project.VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_17)
        targetCompatibility(JavaVersion.VERSION_17)
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":data"))

    implementation(AndroidX.CORE)
    implementation(AndroidX.AppCompat.APP_COMPAT)
    implementation(AndroidX.ConstraintLayout.CONSTRAINT_LAYOUT)

    implementation(Google.METERIAL)

    testImplementation(Junit.JUNIT)
    androidTestImplementation(AndroidX.Test.Ext.JUNIT)
    androidTestImplementation(AndroidX.Test.Espresso.ESPRESSO_CORE)

    implementation(Google.Hilt.HILT_ANDROID)
    kapt(Google.Hilt.HILT_COMPILER)


    implementation(Kotlin.KOTLIN_SERIALIZATION)
    implementation(KotlinX.KOTLINX_SERIALIZATION)
    implementation(KotlinX.KOTLINX_SERIALIZATION_JSON)

    implementation(SquareUp.OkHttp3.CORE)
    implementation(SquareUp.OkHttp3.LOGGING_INTERCEPTOR)
    implementation(SquareUp.Retrofit2.CORE)
    implementation(Kotlin.KOTLIN_SERIALIZATION)
    implementation(KotlinX.KOTLINX_SERIALIZATION)
    implementation(KotlinX.KOTLINX_SERIALIZATION_JSON)

    implementation(SquareUp.OkHttp3.CORE)
    implementation(SquareUp.OkHttp3.LOGGING_INTERCEPTOR)
    implementation(SquareUp.Retrofit2.CORE)
}