package com.github.slo0ey.kwe.database.dao

import com.github.slo0ey.kwe.database.schema.BuildingSchema
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class BuildingDAO(id: EntityID<Long>): LongEntity(id) {
    companion object : LongEntityClass<BuildingDAO>(BuildingSchema)
    var name by BuildingSchema.name
    var owner by UserDAO referencedOn BuildingSchema.owner
    var location by CityDAO referencedOn BuildingSchema.location
    var tenants by BuildingSchema.tenants
}