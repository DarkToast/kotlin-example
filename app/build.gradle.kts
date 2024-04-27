plugins {
   alias(libs.plugins.kotlin)
}

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(21)
}