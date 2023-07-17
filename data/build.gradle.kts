import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id(Plugin.KOTLINX_SERIALIZATION)
    id(Plugin.DAGGER_HILT)
    kotlin(Plugin.KAPT)
}

android {
    namespace = "com.soten.data"
    compileSdk = 33

    defaultConfig {
        minSdk = 26
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(AndroidX.CORE)
    implementation(AndroidX.AppCompat.APP_COMPAT)
    implementation(AndroidX.ConstraintLayout.CONSTRAINT_LAYOUT)

    implementation(Google.METERIAL)

    testImplementation(Junit.JUNIT)
    androidTestImplementation(AndroidX.Test.Ext.JUNIT)
    androidTestImplementation(AndroidX.Test.Espresso.ESPRESSO_CORE)

    implementation(Kotlin.KOTLIN_SERIALIZATION)
    implementation(KotlinX.KOTLINX_SERIALIZATION)
    implementation(KotlinX.KOTLINX_SERIALIZATION_JSON)

    implementation(SquareUp.OkHttp3.CORE)
    implementation(SquareUp.OkHttp3.LOGGING_INTERCEPTOR)
    implementation(SquareUp.Retrofit2.CORE)


    implementation(Google.Hilt.HILT_ANDROID)
    kapt(Google.Hilt.HILT_COMPILER)
}