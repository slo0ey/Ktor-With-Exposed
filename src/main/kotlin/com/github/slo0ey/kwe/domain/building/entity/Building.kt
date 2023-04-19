package com.github.slo0ey.kwe.domain.building.entity

import com.github.slo0ey.kwe.domain.city.entity.Cities
import com.github.slo0ey.kwe.domain.city.entity.City
import com.github.slo0ey.kwe.domain.user.entity.User
import com.github.slo0ey.kwe.domain.user.entity.Users
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.LongIdTable

object Buildings: LongIdTable() {
    val name = varchar("name", 20)
    val owner = reference("owner", Users)
    val location = reference("location", Cities)
    val tenants = integer("tenants")
}

class Building(id: EntityID<Long>): LongEntity(id) {
    companion object : LongEntityClass<Building>(Buildings)
    var name by Buildings.name
    var owner by User referencedOn Buildings.owner
    val location by City referencedOn Buildings.location
    var tenants by Buildings.tenants
}