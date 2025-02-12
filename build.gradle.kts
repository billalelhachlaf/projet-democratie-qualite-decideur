import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

dependencies {
    // Note, if you develop a library, you should use compose.desktop.common.
    // compose.desktop.currentOs should be used in launcher-sourceSet
    // (in a separate module for demo project and in testMain).
    // With compose.desktop.common you will also lose @Preview functionality
    implementation(compose.desktop.currentOs)
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("org.jsoup:jsoup:1.16.1")



}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            //targetFormats(TargetFormat.Dmg)
            //targetFormats(TargetFormat.Exe)
            //targetFormats(TargetFormat.Deb)
            //targetFormats(TargetFormat.AppImage)
            packageName = "projet-democratie-qualite-decideur"
            packageVersion = "1.0.0"
        }
    }
}
