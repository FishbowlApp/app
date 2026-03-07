@file:OptIn(ExperimentalWasmDsl::class)

import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
  kotlin("multiplatform")
  id("org.jetbrains.compose")
  id("org.jetbrains.kotlin.plugin.compose")
}

kotlin {
  wasmJs {
    browser {
      commonWebpackConfig {
        outputFileName = "octocon-app.js"
      }
    }
    useEsModules()
    binaries.executable()
  }

  sourceSets {
    val wasmJsMain by getting {
      dependencies {
        implementation(project(":shared"))

        implementation("org.jetbrains.compose.ui:ui:1.11.0-alpha03")
        implementation("org.jetbrains.compose.foundation:foundation:1.11.0-alpha03")

        implementation("org.jetbrains.kotlinx:kotlinx-browser-wasm-js:0.5.0")
      }
    }
  }
}