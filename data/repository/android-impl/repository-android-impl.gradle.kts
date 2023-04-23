plugins {
    kotlin("kapt")
    kotlin("android")
    kotlin("plugin.serialization")
    id("com.android.library")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.tjackapps.rapidtouch.repository.androidimpl"
    compileSdk = 33

    defaultConfig {
        minSdk = 26
//        targetSdk = 33
    }

    hilt {
        enableAggregatingTask = true
    }
}

dependencies {
    implementation(project(":data:models"))
    implementation(project(mapOf("path" to ":data:repository:api")))
    implementation(project(mapOf("path" to ":data:preferences:api")))
    implementation("com.google.dagger:hilt-android:2.45")
    kapt("com.google.dagger:hilt-compiler:2.45")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")
}