plugins {
    alias(libs.plugins.harrypotter.android.library)
}

android {
    namespace = "com.handongwook.harry_potter.core.model"
}

dependencies {
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
}