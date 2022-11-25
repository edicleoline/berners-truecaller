plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = Versions.COMPILE_SDK
    defaultConfig {
        minSdk = Versions.MIN_SDK
        targetSdk = Versions.TARGET_SDK
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-proguard-rules.pro")
    }

    buildTypes {
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
        disable += "InvalidPackage"
        // Version changes are beyond our control, so don't warn. The IDE will still mark these.
        disable += "GradleDependency"
    }

    // Required by ArWebView
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    api(platform(project(":depconstraints")))
    implementation(project(":shared"))
    implementation(Libs.APPCOMPAT)
    implementation(Libs.ARCORE)
    implementation(Libs.GOOGLE_PLAY_SERVICES_VISION)
    implementation(Libs.KOTLIN_STDLIB)
}
