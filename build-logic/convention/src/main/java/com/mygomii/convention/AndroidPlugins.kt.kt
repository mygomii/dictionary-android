package com.mygomii.convention

import org.gradle.api.Project

fun Project.configureAndroidPlugins() {
    pluginManager.apply("com.android.application")
    pluginManager.apply("org.jetbrains.kotlin.android")
    pluginManager.apply("com.google.devtools.ksp")
    pluginManager.apply("org.jetbrains.kotlin.plugin.compose")
}
