package com.github.slo0ey.kwe.database.schema

import com.github.slo0ey.kwe.entity.User
import org.jetbrains.exposed.dao.id.IntIdTable

object UserSchema: IntIdTable() {
    val name = varchar("name", 24)
    val age = integer("age")
    val gender = enumeration("gender", User.Gender::class)
}