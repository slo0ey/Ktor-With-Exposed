package com.github.slo0ey.kwe.database.dao

import com.github.slo0ey.kwe.database.schema.UserSchema
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class UserDAO(id: EntityID<Long>): LongEntity(id) {
    companion object : LongEntityClass<UserDAO>(UserSchema)
    var name by UserSchema.name
    var age by UserSchema.age
    var gender by UserSchema.gender
}