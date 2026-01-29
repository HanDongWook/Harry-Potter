plugins {
    alias(libs.plugins.harrypotter.android.library)
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "com.handongwook.harry_potter.core.navigation"
}

dependencies {
    api(libs.kotlinx.serialization.core)

    implementation(libs.androidx.navigation3.runtime)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
}