package com.github.slo0ey.kwe.global.database

import com.github.slo0ey.kwe.database.schema.BuildingSchema
import com.github.slo0ey.kwe.database.schema.CitySchema
import com.github.slo0ey.kwe.database.schema.UserSchema
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

fun initDB() {
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
}