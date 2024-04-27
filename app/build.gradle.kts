plugins {
   alias(libs.plugins.kotlin)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.web.ktor.server.core)
    implementation(libs.web.ktor.server.netty)
    implementation(libs.logging.kotlin)
    implementation(libs.logging.logback)

    implementation(libs.db.exposed.core)
    implementation(libs.di.koin.core)

    testImplementation(libs.test.ktor.server)
    testImplementation(libs.test.kotlin)
}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
    testLogging.showStandardStreams = true
}