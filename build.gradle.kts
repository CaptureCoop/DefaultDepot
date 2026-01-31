plugins {
    kotlin("jvm") version "2.3.0"
    id("org.jetbrains.dokka") version "2.1.0"
    id("com.vanniktech.maven.publish") version "0.36.0"
}

group = "org.capturecoop"
version = "1.9.7"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
}

val sourcesJar by tasks.registering(Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
}

val dokkaHtml by tasks.getting(org.jetbrains.dokka.gradle.DokkaTask::class)
val javadocJar by tasks.registering(Jar::class) {
    archiveClassifier.set("javadoc")
    from(dokkaHtml.outputDirectory)
}

kotlin {
    jvmToolchain(21)
}

mavenPublishing {
    publishToMavenCentral()
    signAllPublications()

    coordinates("org.capturecoop", "defaultdepot", version.toString())

    pom {
        name.set("DefaultDepot")
        description.set("Default Depository of Utility Functions.")
        inceptionYear.set("2022")
        url.set("https://github.com/CaptureCoop/DefaultDepot/")
        licenses {
            license {
                name.set("MIT")
                url.set("https://github.com/CaptureCoop/DefaultDepot/blob/main/LICENSE")
                distribution.set("https://github.com/CaptureCoop/DefaultDepot/blob/main/LICENSE")
            }
        }
        developers {
            developer {
                id.set("SvenWollinger")
                name.set("Sven Wollinger")
                url.set("https://wollinger.io")
            }
        }
        scm {
            url.set("https://github.com/CaptureCoop/DefaultDepot/")
            connection.set("scm:git:git://github.com/CaptureCoop/DefaultDepot.git")
            developerConnection.set("scm:git:ssh://git@github.com/CaptureCoop/DefaultDepot.git")
        }
    }
}