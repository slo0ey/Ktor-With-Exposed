package com.github.slo0ey.kwe.database.schema

import org.jetbrains.exposed.dao.id.LongIdTable

object BuildingSchema: LongIdTable() {
    val name = varchar("name", 20)
    val owner = reference("owner", UserSchema)
    val location = reference("location", CitySchema)
    val tenants = integer("tenants")
}