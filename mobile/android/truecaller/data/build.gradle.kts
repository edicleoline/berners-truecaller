plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Versions.COMPILE_SDK
    defaultConfig {
        minSdk = Versions.MIN_SDK
        targetSdk = Versions.TARGET_SDK
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        consumerProguardFiles("consumer-proguard-rules.pro")

        javaCompileOptions {
            annotationProcessorOptions {
                arguments["room.incremental"] = "true"
            }
        }
    }

    buildTypes {
        getByName("release") {            
            buildConfigField("String", "TRUECALLER_API_BASE_URL", "\"http://192.168.15.145:8000/api/\"")
        }
        getByName("debug") {           
            buildConfigField("String", "TRUECALLER_API_BASE_URL", "\"http://192.168.15.145:8000/api/\"")
        }
        maybeCreate("staging")
        getByName("staging") {
            initWith(getByName("debug"))

            // Specifies a sorted list of fallback build types that the
            // plugin should try to use when a dependency does not include a
            // "staging" build type.
            // Used with :test-shared, which doesn't have a staging variant.
            matchingFallbacks += listOf("debug")
        }
        maybeCreate("benchmark")
        getByName("benchmark") {
            initWith(getByName("staging"))
            // Specifies a sorted list of fallback build types that the
            // plugin should try to use when a dependency does not include a
            // "staging" build type.
            // Used with :test-shared, which doesn't have a staging variant.
            matchingFallbacks += listOf("staging", "debug")
        }
    }

    lint {
        disable += listOf("InvalidPackage", "MissingTranslation")
        // Version changes are beyond our control, so don't warn. The IDE will still mark these.
        disable += "GradleDependency"
        // Timber needs to update to new Lint API
        disable += "ObsoleteLintCustomCheck"
    }

    // debug and release variants share the same source dir
    sourceSets {
        getByName("debug") {
            java.srcDir("src/debugRelease/java")
        }
        getByName("release") {
            java.srcDir("src/debugRelease/java")
        }
        getByName("benchmark") {
            java.srcDir("src/staging/java")
            res.srcDir("src/staging/res")
        }
    }

    // Some libs (such as androidx.core:core-ktx 1.2.0 and newer) require Java 8
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    // To avoid the compile error: "Cannot inline bytecode built with JVM target 1.8
    // into bytecode that is being built with JVM target 1.6"
    kotlinOptions {
        val options = this as org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
        options.jvmTarget = "1.8"
    }
}

dependencies {
    api(platform(project(":depconstraints")))
    kapt(platform(project(":depconstraints")))
    api(project(":model"))
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    testImplementation(project(":test-shared"))
//    testImplementation(project(":androidTest-shared"))

    // AppCompat
    implementation(Libs.APPCOMPAT)

    // Architecture Components
    implementation(Libs.LIFECYCLE_LIVE_DATA_KTX)
    implementation(Libs.LIFECYCLE_VIEW_MODEL_KTX)
    implementation(Libs.ROOM_KTX)
    implementation(Libs.ROOM_RUNTIME)
    kapt(Libs.ROOM_COMPILER)
    testImplementation(Libs.ARCH_TESTING)

    // Utils
    api(Libs.TIMBER)
    implementation(Libs.GSON)
    implementation(Libs.CORE_KTX)

    //Retrofit
    implementation(Libs.RETROFIT)
    implementation(Libs.MOSHI_KOTLIN)
    implementation(Libs.RETROFIT_MOSHI_CONVERTER)
    implementation(Libs.MOSHI_ADAPTERS)

    // OkHttp
    implementation(Libs.OKHTTP)
    implementation(Libs.OKHTTP_LOGGING_INTERCEPTOR)

    // Kotlin
    implementation(Libs.KOTLIN_STDLIB)

    // Coroutines
    api(Libs.COROUTINES)
    testImplementation(Libs.COROUTINES_TEST)

    // Dagger Hilt
    implementation(Libs.HILT_ANDROID)
    kapt(Libs.HILT_COMPILER)

    // DataStore
    implementation(Libs.DATA_STORE_PREFERENCES)

    // Has to be replaced to avoid compile / runtime conflicts between okhttp and firestore
    api(Libs.OKIO)

    // ThreeTenBP for the shared module only. Date and time API for Java.
//    testImplementation(Libs.THREETENBP)
//    compileOnly("org.threeten:threetenbp:${Versions.THREETENBP}:no-tzdb")

    implementation(Libs.KOTLINX_DATETIME)

    // Unit tests
    testImplementation(Libs.JUNIT)
    testImplementation(Libs.HAMCREST)
    testImplementation(Libs.MOCKITO_CORE)
    testImplementation(Libs.MOCKITO_KOTLIN)

    // unit tests livedata
    testImplementation(Libs.ARCH_TESTING)
}

//apply(plugin = "com.google.gms.google-services")
