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
    namespace = "com.tjackapps.rapidtouch.repository.androidglue"
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
    api(project(":data:repository:api"))
    api(project(":data:repository:android-impl"))
    implementation("com.google.dagger:hilt-android:2.44.2")
    kapt("com.google.dagger:hilt-compiler:2.44.2")
}
