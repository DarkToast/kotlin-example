plugins {
   alias(libs.plugins.kotlin)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)

    testImplementation(libs.ktor.server.test)
    testImplementation(libs.kotlin.test)
}

kotlin {
    jvmToolchain(21)
}