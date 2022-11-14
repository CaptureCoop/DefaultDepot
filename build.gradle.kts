import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
}

group = "org.capturecoop"
version = "1.9.4"

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.apache.commons:commons-lang3:3.12.0'
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}