plugins {
    alias(libs.plugins.harrypotter.android.library)
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "com.handongwook.harry_potter.core.network"

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    api(libs.koin.core)
    api(libs.kotlinx.serialization.core)
    api(libs.retrofit)

    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging.interceptor)
    implementation(libs.retrofit.kotlinx.serialization)
    implementation(libs.kotlinx.serialization.json)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
}
