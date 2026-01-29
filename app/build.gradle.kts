plugins {
    alias(libs.plugins.harrypotter.android.application)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.handongwook.harry_potter"

    defaultConfig {
        applicationId = "com.handongwook.harry_potter"
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }

    buildFeatures {
        buildConfig = true
        compose = true
    }
}

dependencies {
    // core
    implementation(projects.core.navigation)

    // feature
    implementation(projects.feature.characters)
    implementation(projects.feature.details)

    // compose
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // navigation
    implementation(libs.androidx.navigation3.runtime)
    implementation(libs.androidx.navigation3.ui)

    // koin
    implementation(libs.koin.android)

    // coil
    implementation(libs.coil.compose)
    implementation(libs.coil.network.okhttp)

    // others
    implementation(libs.androidx.startup)
    implementation(libs.timber)

    // test
    testImplementation(libs.junit)

    // android test
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))

    // debug
    debugImplementation(libs.androidx.ui.tooling)
    debugRuntimeOnly(libs.androidx.ui.test.manifest)
}
