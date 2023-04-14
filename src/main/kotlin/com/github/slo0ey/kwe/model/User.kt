package com.github.slo0ey.kwe.model

import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.LongIdTable

object Users: LongIdTable() {
    val name = varchar("name", 24)
    val age = integer("age")
    val gender = enumeration("gender", Gender::class)
}

class User(id: EntityID<Long>): LongEntity(id) {
    companion object : LongEntityClass<User>(Users)
    val name by Users.name
    val age by Users.age
    val gender by Users.gender
}

enum class Gender {
    MALE, FEMALE
}