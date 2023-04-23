plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
}

kotlin {
    android()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")
            }
        }
    }
}

android {
    namespace = "com.tjackapps.rapidtouch.models"
    compileSdk = 33

    defaultConfig {
        minSdk = 26
//        targetSdk = 33
    }
}