package com.github.slo0ey.kwe.domain.city.entity

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object Cities: IntIdTable() {
    val name = varchar("name", 10)
    val reputation = integer("reputation")
}

class City(id: EntityID<Int>): IntEntity(id) {
    companion object : IntEntityClass<City>(Cities)
    var name by Cities.name
    var reputation by Cities.reputation
}