plugins {
    kotlin("jvm") version "1.9.22"
}

group = "org.capturecoop"
version = "0.0.1"

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(8)
}