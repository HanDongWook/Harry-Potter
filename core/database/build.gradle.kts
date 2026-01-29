plugins {
    alias(libs.plugins.harrypotter.android.library)
}

android {
    namespace = "com.handongwook.harry_potter.core.database"
}

dependencies {
    api(project(":core:model"))
    api(libs.koin.core)

    implementation(libs.koin.android)
    implementation(libs.androidx.room.runtime)
    runtimeOnly(libs.androidx.room.compiler)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
}