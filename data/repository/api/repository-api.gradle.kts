plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

kotlin {
    android()
}

android {
    namespace = "com.tjackapps.rapidtouch.repository.api"
    compileSdk = 33

    defaultConfig {
        minSdk = 26
//        targetSdk = 33
    }
}

dependencies {
    implementation(project(":data:models"))
    implementation(project(":shared"))
}