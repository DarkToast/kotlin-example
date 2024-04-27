plugins {
   alias(libs.plugins.kotlin)
   alias(libs.plugins.serialization)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.web.ktor.server.core)
    implementation(libs.web.ktor.server.netty)
    implementation(libs.web.ktor.server.pages)
    implementation(libs.web.ktor.server.content.negotiation)
    implementation(libs.web.ktor.serialization.json)

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