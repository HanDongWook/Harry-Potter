plugins {
    alias(libs.plugins.harrypotter.android.library)
}

android {
    namespace = "com.handongwook.harry_potter.core.data"
}

dependencies {
    api(projects.core.network)
    api(projects.core.model)
    api(libs.koin.core)
    api(libs.kotlinx.coroutines.core)

    implementation(libs.timber)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
}
