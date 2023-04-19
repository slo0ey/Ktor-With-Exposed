package com.github.slo0ey.kwe.global.plugin

import com.github.slo0ey.kwe.router.userRouter
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.setUpRouter() {
    install(Routing) {
        userRouter()
    }
}