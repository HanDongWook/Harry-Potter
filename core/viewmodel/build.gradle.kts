plugins {
    alias(libs.plugins.harrypotter.android.library)
}

android {
    namespace = "com.handongwook.harry_potter.core.viewmodel"
}

dependencies {
    api(libs.androidx.lifecycle.viewmodel)
    api(libs.koin.core)
    api(libs.kotlinx.coroutines.core)

    implementation(libs.koin.core.viewmodel)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
}