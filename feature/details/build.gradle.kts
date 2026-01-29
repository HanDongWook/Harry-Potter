plugins {
    alias(libs.plugins.harrypotter.android.library)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.handongwook.harry_potter.feature.details"

    buildFeatures {
        compose = true
    }
}

dependencies {
    api(project(":core:data"))
    api(project(":core:model"))
    api(project(":core:viewmodel"))

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    implementation(libs.koin.androidx.compose)
    implementation(libs.orbit.viewmodel)
    implementation(libs.orbit.compose)

    implementation(libs.coil.compose)
    implementation(libs.timber)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
}