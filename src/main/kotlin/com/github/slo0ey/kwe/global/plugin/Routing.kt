package com.github.slo0ey.kwe.global.plugin

import com.github.slo0ey.kwe.domain.building.buildingRoute
import com.github.slo0ey.kwe.domain.city.cityRoute
import com.github.slo0ey.kwe.domain.user.userRoute
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.setUpRouter() {
    install(Routing) {
        userRoute()
        cityRoute()
        buildingRoute()
    }
}