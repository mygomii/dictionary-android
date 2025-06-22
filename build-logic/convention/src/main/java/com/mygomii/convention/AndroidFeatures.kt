package com.mygomii.convention

import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Project

internal fun Project.configureFeature() {
    extensions.configure<ApplicationExtension>("android") {
        buildFeatures {
            compose = true
        }
    }
}
