plugins {
    kotlin("kapt")
    kotlin("android")
    id("com.android.library")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.tjackapps.rapidtouch.preferences.androidimpl"
    compileSdk = 33

    defaultConfig {
        minSdk = 26
        targetSdk = 33
    }
}

dependencies {
    api(project(":data:preferences:api"))
    implementation("androidx.datastore:datastore-preferences:1.0.0")
    implementation("com.google.dagger:hilt-android:2.44.2")
    kapt("com.google.dagger:hilt-compiler:2.44.2")
}
