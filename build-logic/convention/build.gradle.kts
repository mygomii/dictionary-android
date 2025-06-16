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

    implementation("com.google.devtools.ksp:com.google.devtools.ksp.gradle.plugin:2.1.21-2.0.1")
}

gradlePlugin {
    plugins {
        create("androidComposeApplication") {
            id = "mygomii.android.application"
            // 이 클래스 경로가 실제 소스의 패키지·클래스명과 100% 일치해야 합니다
            implementationClass =
                "com.mygomii.convention.AndroidComposeApplicationPlugin"
        }
    }
}