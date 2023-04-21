package com.github.slo0ey.kwe.database.dao

import com.github.slo0ey.kwe.database.schema.UserSchema
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class UserDAO(id: EntityID<Int>): IntEntity(id) {
    companion object : IntEntityClass<UserDAO>(UserSchema)
    var name by UserSchema.name
    var age by UserSchema.age
    var gender by UserSchema.gender
}