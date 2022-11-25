plugins {
    id("java-library")
    kotlin("jvm")
}

dependencies {
    api(platform(project(":depconstraints")))

//    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(Libs.CORE_KTX)
    implementation(Libs.KOTLINX_DATETIME)
    implementation(Libs.KOTLIN_STDLIB)

    // Unit tests
    testImplementation(Libs.JUNIT)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}