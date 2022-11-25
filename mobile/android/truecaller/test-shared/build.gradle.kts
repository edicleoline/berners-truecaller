plugins {
    id("java-library")
    kotlin("jvm")
}

dependencies {
    api(platform(project(":depconstraints")))
    implementation(project(":model"))
    // Kotlin
    implementation(Libs.KOTLIN_STDLIB)

    // Test
    implementation(Libs.JUNIT)
    api(Libs.COROUTINES_TEST)

    // ThreeTenBP for the shared module only. Date and time API for Java.
    testImplementation(Libs.THREETENBP)
    compileOnly("org.threeten:threetenbp:${Versions.THREETENBP}:no-tzdb")
}