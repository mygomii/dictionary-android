package com.mygomii.convention

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

fun Project.configureDependencies() {
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

    dependencies {
        // 모듈
        add("implementation", project(":data"))
        add("implementation", project(":domain"))
        // AndroidX & Compose
        add("implementation", libs.findLibrary("androidx.core.ktx").get())
        add("implementation", libs.findLibrary("androidx.lifecycle.runtime.ktx").get())
        add("implementation", libs.findLibrary("androidx.activity.compose").get())
        add("implementation", platform(libs.findLibrary("androidx.compose.bom").get()))
        add("implementation", libs.findLibrary("androidx.compose.ui").get())
        add("implementation", libs.findLibrary("androidx.compose.ui.graphics").get())
        add("implementation", libs.findLibrary("androidx.compose.ui.tooling.preview").get())
        add("implementation", libs.findLibrary("androidx.compose.material3").get())
        // Test / Debug
        add("testImplementation", libs.findLibrary("junit").get())
        add("androidTestImplementation", libs.findLibrary("androidx.test.ext.junit").get())
        add("androidTestImplementation", libs.findLibrary("androidx.test.espresso.core").get())
        add("androidTestImplementation", platform(libs.findLibrary("androidx.compose.bom").get()))
        add("androidTestImplementation", libs.findLibrary("androidx.compose.ui.test.junit4").get())
        add("debugImplementation", libs.findLibrary("androidx.compose.ui.tooling").get())
        add("debugImplementation", libs.findLibrary("androidx.compose.ui.test.manifest").get())
        // Ktor
        add("implementation", libs.findLibrary("io.ktor.client.core").get())
        add("implementation", libs.findLibrary("io.ktor.client.okhttp").get())
        add("implementation", libs.findLibrary("io.ktor.client.serialization").get())
        // Koin
        add("implementation", platform(libs.findLibrary("io.insert-koin.koin-bom").get()))
        add("implementation", libs.findLibrary("io.insert-koin.koin-android").get())
        add("implementation", libs.findLibrary("io.insert-koin.koin-core").get())
        add("implementation", libs.findLibrary("io.insert-koin.koin-androidx-compose").get())
    }
}