package com.github.slo0ey.kwe.domain.user

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
    var name by Users.name
    var age by Users.age
    val gender by Users.gender // hmm... I don't want to allow to change gender.
}

enum class Gender {
    MALE, FEMALE
}