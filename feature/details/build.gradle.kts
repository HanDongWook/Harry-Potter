plugins {
    alias(libs.plugins.harrypotter.android.library)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.handongwook.harry_potter.feature.details"

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
    api(project(":core:data"))
    api(project(":core:model"))
    api(project(":core:viewmodel"))
    api(libs.androidx.compose.runtime)
    api(libs.koin.core)
    api(libs.kotlinx.coroutines.core)
    api(libs.orbit.core)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.text)
    implementation(libs.androidx.ui.unit)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.foundation.layout)
    implementation(libs.androidx.compose.runtime.annotation)
    implementation(libs.androidx.lifecycle.common)
    implementation(libs.androidx.lifecycle.viewmodel)
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    implementation(libs.koin.androidx.compose)
    implementation(libs.koin.compose)
    implementation(libs.koin.core.viewmodel)

    implementation(libs.orbit.viewmodel)
    implementation(libs.orbit.compose)

    implementation(libs.coil.compose)
    implementation(libs.coil.network.okhttp)
    implementation(libs.timber)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.test.monitor)
    androidTestImplementation(libs.junit)
    androidTestRuntimeOnly(libs.androidx.test.runner)
}