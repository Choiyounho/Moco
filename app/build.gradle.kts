plugins {
    id(Plugin.Android_Application)
    id(Plugin.JETBRAINS_KOTLIN_ANDROID)
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
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {

    implementation(AndroidX.CORE)
    implementation(AndroidX.AppCompat.APP_COMPAT)
    implementation(Google.METERIAL)
    implementation(AndroidX.ConstraintLayout.CONSTRAINT_LAYOUT)
    testImplementation(Junit.JUNIT)
    androidTestImplementation(AndroidX.Test.Ext.JUNIT)
    androidTestImplementation(AndroidX.Test.Espresso.ESPRESSO_CORE)
}