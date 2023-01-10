plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.tjackapps.rapidtouch.android"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.tjackapps.rapidtouch.android"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0"
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
    val composeBomVersion = "2022.12.00"
    val composeCompilerVersion = "1.3.2"
    val activityComposeVersion = "1.6.1"
    val material3ComposeVersion = "1.0.1"
    // navigation
    val navigationVersion = "2.5.3"
    val navigationComposeVersion = "1.0.0"

    implementation(project(":shared"))

    implementation(platform("androidx.compose:compose-bom:$composeBomVersion"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.compose.foundation:foundation")

    implementation("androidx.compose.material3:material3:$material3ComposeVersion")

    implementation("androidx.activity:activity-compose:$activityComposeVersion")

    implementation("androidx.hilt:hilt-navigation-compose:$navigationComposeVersion")
}