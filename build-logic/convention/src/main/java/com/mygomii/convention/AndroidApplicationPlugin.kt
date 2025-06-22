package com.mygomii.convention

import org.gradle.api.Plugin
import org.gradle.api.Project

internal class AndroidApplicationPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.configureAndroidPlugins()
        project.configureAndroidBlock()
        project.configureFeature()
    }
}
