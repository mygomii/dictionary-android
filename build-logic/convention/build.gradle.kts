import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

group = "com.mygomii.build_logic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
    compileOnly(libs.compose.compiler.gradle.plugin)

    implementation(libs.com.google.devtools.ksp.gradle.plugin)
}

gradlePlugin {
    plugins {
        create("androidComposeApplication") {
            id = "mygomii.android.application"
            implementationClass = "com.mygomii.convention.AndroidComposeApplicationPlugin"
        }
    }
}