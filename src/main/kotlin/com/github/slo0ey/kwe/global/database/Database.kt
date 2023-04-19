package com.github.slo0ey.kwe.global.database

import com.github.slo0ey.kwe.domain.building.entity.Buildings
import com.github.slo0ey.kwe.domain.city.entity.Cities
import com.github.slo0ey.kwe.domain.user.entity.Users
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

suspend fun <T> dbQuery(query: Transaction.() -> T): T = withContext(Dispatchers.IO) {
    transaction {
        query()
    }
}

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

        SchemaUtils.create(Users)
        SchemaUtils.create(Buildings)
        SchemaUtils.create(Cities)
    }
}