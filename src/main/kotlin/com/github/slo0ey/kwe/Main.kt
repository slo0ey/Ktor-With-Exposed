package com.github.slo0ey.kwe

import com.github.slo0ey.kwe.global.database.initDB
import com.github.slo0ey.kwe.global.plugin.setUpCommonPlugins
import com.github.slo0ey.kwe.global.plugin.setUpRouter
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(args: Array<String>) {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = {
        setUpCommonPlugins()
        setUpRouter()

        initDB()
    }).start(wait = true)
}