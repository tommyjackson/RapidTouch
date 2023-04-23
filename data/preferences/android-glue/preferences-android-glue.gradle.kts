plugins {
    kotlin("kapt")
    kotlin("android")
    id("com.android.library")
    id("dagger.hilt.android.plugin")
}

kapt {
    useBuildCache = true
}

android {
    namespace = "com.tjackapps.rapidtouch.preferences.androidglue"
    compileSdk = 33

    defaultConfig {
        minSdk = 26
        targetSdk = 33
    }

    hilt {
        enableAggregatingTask = true
    }
}

dependencies {
    api(project(":data:preferences:api"))
    api(project(":data:preferences:android-impl"))
    implementation("com.google.dagger:hilt-android:2.45")
    kapt("com.google.dagger:hilt-compiler:2.45")
}
