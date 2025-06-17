package com.mygomii.convention

import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project

fun Project.configureAndroidBlock() {
    extensions.configure<ApplicationExtension>("android") {
        namespace = "com.mygomii.dictionary"
        compileSdk = 35

        defaultConfig {
            applicationId = "com.mygomii.dictionary"
            minSdk = 24
            targetSdk = 35
            versionCode = 1
            versionName = "1.0"
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }

        buildTypes {
            getByName("release").apply {
                isMinifyEnabled = false
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    project.file("proguard-rules.pro")
                )
            }
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }
    }
}
