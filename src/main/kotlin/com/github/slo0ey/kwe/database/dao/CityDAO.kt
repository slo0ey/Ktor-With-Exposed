package com.github.slo0ey.kwe.database.dao

import com.github.slo0ey.kwe.database.schema.CitySchema
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class CityDAO(id: EntityID<Int>): IntEntity(id) {
    companion object : IntEntityClass<CityDAO>(CitySchema)
    var name by CitySchema.name
    var reputation by CitySchema.reputation
}