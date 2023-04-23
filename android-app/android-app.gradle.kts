plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.tjackapps.rapidtouch.androidapp"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.tjackapps.rapidtouch"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        val composeCompilerVersion = "1.4.6"
        kotlinCompilerExtensionVersion = composeCompilerVersion
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    val composeBomVersion = "2023.03.00"
    val activityComposeVersion = "1.7.1"
    val material3ComposeVersion = "1.1.0-alpha01"

    // navigation
    val navigationVersion = "2.5.3"
    val hiltNavigationComposeVersion = "1.1.0-alpha01"

    implementation(project(":shared"))
    implementation(project(":data:models"))
    implementation(project(":data:preferences:api"))
    implementation(project(":data:preferences:android-glue"))
    implementation(project(":data:repository:api"))
    implementation(project(":data:repository:android-glue"))

    implementation(platform("androidx.compose:compose-bom:$composeBomVersion"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.compose.foundation:foundation")
    implementation("androidx.compose.material3:material3:$material3ComposeVersion")
    implementation("androidx.activity:activity-compose:$activityComposeVersion")
    implementation("androidx.hilt:hilt-navigation-compose:$hiltNavigationComposeVersion")
    implementation("androidx.navigation:navigation-compose:$navigationVersion")

    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")

    implementation("com.google.dagger:hilt-android:2.45")
    kapt("com.google.dagger:hilt-compiler:2.45")
}