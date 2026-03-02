@file:OptIn(ExperimentalWasmDsl::class)

import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
  kotlin("multiplatform")
  id("com.android.library")
  id("org.jetbrains.compose")
  id("org.jetbrains.kotlin.plugin.compose")
}

kotlin {
  jvm("desktop")
  androidTarget()

  /*listOf(
    iosArm64(),
    iosSimulatorArm64()
  ).forEach {
    it.binaries.framework {
      baseName = "krop"
      isStatic = true
    }
  }*/

  iosArm64()
  iosSimulatorArm64()

  wasmJs { browser() }

  applyDefaultHierarchyTemplate()

  sourceSets {
    val commonMain by getting {
      dependencies {
        compileOnly("org.jetbrains.compose.runtime:runtime:1.11.0-alpha03")
        compileOnly("org.jetbrains.compose.foundation:foundation:1.11.0-alpha03")
        compileOnly("org.jetbrains.compose.material3:material3:1.11.0-alpha03")
        implementation("org.jetbrains.compose.material:material-icons-core:1.7.3")
        implementation("org.jetbrains.compose.material:material-icons-extended:1.7.3")
        // compileOnly("org.jetbrains.compose.material3:material3:1.8.0+dev2098")
        implementation("org.jetbrains.compose.components:components-resources:1.11.0-alpha03")
      }
    }
    val iosMain by getting {
      dependencies {
        api("androidx.performance:performance-annotation:1.0.0-alpha01")
      }
    }
  }
}

android {
  namespace = "app.octocon.krop"
  compileSdk = (findProperty("android.compileSdk") as String).toInt()
  defaultConfig {
    minSdk = (findProperty("android.minSdk") as String).toInt()
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
  kotlin {
    jvmToolchain(17)
  }
}
