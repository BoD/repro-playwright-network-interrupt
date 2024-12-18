plugins {
    kotlin("jvm") version "2.0.21"
    application
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.microsoft.playwright:playwright:1.44.0") // WORKS
//    implementation("com.microsoft.playwright:playwright:1.45.0") // DOES NOT WORK
}

application {
    mainClass.set("com.example.MainKt")
}

kotlin {
    jvmToolchain(17)
}
