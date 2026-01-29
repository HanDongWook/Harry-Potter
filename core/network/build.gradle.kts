plugins {
    alias(libs.plugins.harrypotter.android.library)
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "com.handongwook.harry_potter.core.network"

    defaultConfig {
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
    }
}

dependencies {
    // coroutines
    api(libs.koin.core)
    api(libs.kotlinx.serialization.core)
    api(libs.retrofit)

    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.test)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging.interceptor)

    runtimeOnly(libs.kotlinx.coroutines.android)

    // network
    implementation(libs.retrofit.kotlinx.serialization)
    implementation(libs.kotlinx.serialization.json)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.test.monitor)
    androidTestImplementation(libs.junit)
    androidTestRuntimeOnly(libs.androidx.loader)
    androidTestRuntimeOnly(libs.androidx.recyclerview)
    androidTestRuntimeOnly(libs.androidx.test.runner)

    runtimeOnly(libs.androidx.transition)
}
