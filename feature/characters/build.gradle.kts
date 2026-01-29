plugins {
    alias(libs.plugins.harrypotter.android.library)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.handongwook.harry_potter.feature.characters"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(projects.core.data)
    implementation(projects.core.model)
    implementation(projects.core.viewmodel)
    implementation(projects.core.navigation)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose)

    implementation(libs.orbit.viewmodel)
    implementation(libs.orbit.compose)
    implementation(libs.orbit.test)

    implementation(libs.coil.compose)
    implementation(libs.coil.network.okhttp)
    implementation(libs.timber)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}