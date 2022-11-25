plugins {
    id("com.android.library")
    kotlin("android")
    id("androidx.benchmark")
    kotlin("kapt")
}

android {
    compileSdk = Versions.COMPILE_SDK
    defaultConfig {
        minSdk = Versions.MIN_SDK
        targetSdk = Versions.TARGET_SDK
        testInstrumentationRunner = "androidx.benchmark.junit4.AndroidBenchmarkRunner"
    }

    buildTypes {
        maybeCreate("benchmark")
        getByName("benchmark") {
            initWith(getByName("release"))
            signingConfig = signingConfigs.getByName("debug")
            isDefault = true
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"))

            // Specifies a sorted list of fallback build types that the
            // plugin should try to use when a dependency does not include a
            // "staging" build type.
            // Used with :test-shared, which doesn't have a staging variant.
            matchingFallbacks += listOf("staging", "debug")
        }
    }

    testBuildType = "benchmark"

    // To avoid the compile error from benchmarkRule.measureRepeated
    // Cannot inline bytecode built with JVM target 1.8 into bytecode that is being built with JVM
    // target 1.6
    kotlinOptions.jvmTarget = "1.8"

    packagingOptions {
        resources.excludes += "META-INF/AL2.0"
        resources.excludes += "META-INF/LGPL2.1"
    }
}

dependencies {
    androidTestImplementation(platform(project(":depconstraints")))
    kapt(platform(project(":depconstraints")))
    androidTestImplementation(project(":model"))
    androidTestImplementation(project(":shared"))
    androidTestImplementation(project(":test-shared"))
    androidTestImplementation(project(":androidTest-shared"))

    // ThreeTenBP is for Date and time API for Java.
    androidTestImplementation(Libs.THREETENABP)

    // Instrumentation tests
    androidTestImplementation(Libs.HAMCREST)
    androidTestImplementation(Libs.EXT_JUNIT)
    androidTestImplementation(Libs.RUNNER)
    androidTestImplementation(Libs.RULES)

    // Benchmark testing
    androidTestImplementation(Libs.BENCHMARK)
}
