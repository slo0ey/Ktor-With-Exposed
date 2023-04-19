package com.github.slo0ey.kwe.database.schema

import org.jetbrains.exposed.dao.id.IntIdTable

object CitySchema: IntIdTable() {
    val name = varchar("name", 10)
    val reputation = integer("reputation")
}