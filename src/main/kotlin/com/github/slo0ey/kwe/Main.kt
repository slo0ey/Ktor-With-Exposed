package com.github.slo0ey.kwe

import com.github.slo0ey.kwe.database.schema.BuildingSchema
import com.github.slo0ey.kwe.database.schema.CitySchema
import com.github.slo0ey.kwe.database.schema.UserSchema
import com.github.slo0ey.kwe.router.userRouter
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.routing.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction

fun main(args: Array<String>) {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = {
        val config = HikariConfig().apply {
            jdbcUrl         = "jdbc:mysql://localhost/kwe"
            driverClassName = "com.mysql.cj.jdbc.Driver"
            username        = "slo0ey"
            password        = "p@ssw0rd"
            maximumPoolSize = 10
        }
        val dataSource = HikariDataSource(config)
        Database.connect(dataSource)

        transaction {
            addLogger(StdOutSqlLogger)

            SchemaUtils.createDatabase("kwe")

            SchemaUtils.create(UserSchema)
            SchemaUtils.create(BuildingSchema)
            SchemaUtils.create(CitySchema)
        }

        install(CallLogging)

        install(ContentNegotiation) {
            json()
        }

        install(Routing) {
            userRouter()
        }
    }).start(wait = true)
}