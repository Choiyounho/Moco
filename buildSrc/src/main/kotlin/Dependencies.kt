object Kotlin {
    private const val VERSION = "1.8.20"
    const val GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:$VERSION"
}

object Android {
    object Tools {
        object Build {
            private const val VERSION = "8.0.2"
            const val GRADLE = "com.android.tools.build:gradle:$VERSION"
        }
    }
}

object AndroidX {
    const val CORE = "androidx.core:core-ktx:1.10.1"
    const val DATASTORE_PREFERENCES = "androidx.datastore:datastore-preferences:1.0.0"

    object AppCompat {
        private const val VERSION = "1.6.0"
        const val APP_COMPAT = "androidx.appcompat:appcompat:$VERSION"
    }

    object Activity {
        private const val VERSION = "1.6.0"
        const val ACTIVITY_KTX = "androidx.activity:activity-ktx:$VERSION"
    }

    object Lifecycle {
        private const val VERSION = "2.5.1"
        const val VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:$VERSION"
        const val VIEWMODEL_SAVEDSTATE = "androidx.lifecycle:lifecycle-viewmodel-savedstate:$VERSION"
        const val RUNTIME = "androidx.lifecycle:lifecycle-runtime-ktx:$VERSION"
        const val PROCESS = "androidx.lifecycle:lifecycle-process:$VERSION"

        const val LIFECYCLE_RUNTIME_KTX = "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"
    }

    object ConstraintLayout {
        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:2.1.4"
    }

    object Test {
        object Ext {
            private const val VERSION = "1.1.5"
            const val JUNIT = "androidx.test.ext:junit:$VERSION"
            const val JUNIT_KTX = "androidx.test.ext:junit-ktx:$VERSION"
        }

        object Espresso {
            private const val VERSION = "3.5.1"
            const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:$VERSION"
        }

        const val CORE_KTX = "androidx.test:core-ktx:1.7.0"
    }


    object Navigation {
        private const val VERSION = "2.4.2"
        const val FRAGMENT = "androidx.navigation:navigation-fragment-ktx:$VERSION"
        const val UI = "androidx.navigation:navigation-ui-ktx:$VERSION"
    }

    object Room {
        private const val VERSION = "2.4.3"
        const val RUNTIME = "androidx.room:room-runtime:$VERSION"
        const val COMPILER = "androidx.room:room-compiler:$VERSION"
        const val KTX = "androidx.room:room-ktx:$VERSION"
        const val ROOM_TESTING = "androidx.room:room-testing:$VERSION"
        const val ROOM_PAGING = "androidx.room:room-paging:$VERSION"
    }
}

object Junit {
    private const val VERSION = "4.13.2"
    const val JUNIT = "junit:junit:$VERSION"
}

object Google {
    const val METERIAL = "com.google.android.material:material:1.9.0"
}

object SquareUp {
    object OkHttp3 {
        private const val VERSION = "4.9.3"
        const val CORE = "com.squareup.okhttp3:okhttp:$VERSION"
        const val LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:$VERSION"
    }

    object Retrofit2 {
        private const val VERSION = "2.9.0"
        const val CORE = "com.squareup.retrofit2:retrofit:$VERSION"
        const val GSON = "com.squareup.retrofit2:converter-gson:$VERSION"
        const val RXJAVA2 = "com.squareup.retrofit2:adapter-rxjava2:2.8.1"
    }

    object Moshi {
        private const val VERSION = "1.13.0"
        const val MOSHI = "com.squareup.moshi:moshi:$VERSION"
        const val MOSHI_KOTLIN = "com.squareup.moshi:moshi-kotlin:$VERSION"
        const val MOSHI_ADAPTERS = "com.squareup.moshi:moshi-adapters:$VERSION"
        const val MOSHI_KOTLIN_CODEGEN = "com.squareup.moshi:moshi-kotlin-codegen:$VERSION"
    }
}
