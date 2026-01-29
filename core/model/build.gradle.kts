plugins {
    alias(libs.plugins.harrypotter.android.library)
}

android {
    namespace = "com.handongwook.harry_potter.core.model"

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
    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.test.monitor)
    androidTestImplementation(libs.junit)
    androidTestRuntimeOnly(libs.androidx.loader)
    androidTestRuntimeOnly(libs.androidx.recyclerview)
    androidTestRuntimeOnly(libs.androidx.test.runner)

    runtimeOnly(libs.androidx.transition)
    runtimeOnly(libs.kotlinx.coroutines.android)
}