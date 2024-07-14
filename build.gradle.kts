import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "2.0.0"
    application
}

repositories {
    mavenCentral()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "21"
}

application {
    mainClass.set("com.report.ReportGeneratorKt")
}

dependencies {
    implementation("net.masterthought:cucumber-reporting:5.8.1")
}

tasks.register<Jar>("generateFatJar") {
    from(sourceSets.main.get().output)

    manifest {
        attributes["Main-Class"] = "com.report.ReportGenerator"
    }

    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    from({
        configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) }
    })
}