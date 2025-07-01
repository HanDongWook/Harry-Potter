// Top-level build file where you can add configuration options common to all sub-projects/modules.

val compileSdkVersion = 35
val minSdkVersion = 26
val targetSdkVersion = 35

extra["compileSdkVersion"] = compileSdkVersion
extra["minSdkVersion"] = minSdkVersion
extra["targetSdkVersion"] = targetSdkVersion

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlinx.serialization) apply false
}