// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.ktlint) apply false
}

subprojects {
    if (project.name == "data") {
        apply(plugin = "org.jlleitschuh.gradle.ktlint")

        extensions.configure<org.jlleitschuh.gradle.ktlint.KtlintExtension>("ktlint") {
            version.set("0.48.2")
            android.set(true)
        }
    }
}
