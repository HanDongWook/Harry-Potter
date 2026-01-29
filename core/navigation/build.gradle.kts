plugins {
    alias(libs.plugins.harrypotter.android.library)
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "com.handongwook.harry_potter.core.navigation"

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
}

dependencies {
    api(libs.kotlinx.serialization.core)

    implementation(libs.androidx.navigation3.runtime)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.test.monitor)
    androidTestImplementation(libs.junit)
    androidTestRuntimeOnly(libs.androidx.loader)
    androidTestRuntimeOnly(libs.androidx.recyclerview)
    androidTestRuntimeOnly(libs.androidx.test.runner)

    runtimeOnly(libs.androidx.transition)
}