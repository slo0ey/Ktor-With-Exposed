package com.github.slo0ey.kwe.global.plugin

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.plugins.contentnegotiation.*

fun Application.setUpCommonPlugins() {
    // Logging plugin
    install(CallLogging)
    // Content serializing/deserializing plugin (+ Managing Content-Type Header)
    install(ContentNegotiation) {
        json()
    }
}