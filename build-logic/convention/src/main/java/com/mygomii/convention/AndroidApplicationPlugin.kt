package com.mygomii.convention

import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidComposeApplicationPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.configureAndroidPlugins()
        project.configureAndroidBlock()
        project.configureFeature()
    }
}
