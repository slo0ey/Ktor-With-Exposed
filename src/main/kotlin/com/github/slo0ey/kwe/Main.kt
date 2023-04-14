package com.github.slo0ey.kwe

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.routing.*

fun Application.module() {
    install(CallLogging)
    install(ContentNegotiation) {
        json()
    }

    install(Routing) {
        // Soon..
    }
}

fun main(args: Array<String>) {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = { module() })
        .start(wait = true)
}