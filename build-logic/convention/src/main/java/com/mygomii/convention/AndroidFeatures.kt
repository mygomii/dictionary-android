package com.mygomii.convention

import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

fun Project.configureFeature() {
    extensions.configure<ApplicationExtension>("android") {
        buildFeatures {
            compose = true
        }
        composeOptions {
            val libs = extensions.getByType<VersionCatalogsExtension>()
                .named("libs")
//            kotlinCompilerExtensionVersion =
//                libs.findVersion("androidx-compose-compiler").get().requiredVersion
        }
        // Kotlin JVM target
//        extensions.configure<org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions>("kotlinOptions") {
//            jvmTarget = "17"
//        }
    }
}