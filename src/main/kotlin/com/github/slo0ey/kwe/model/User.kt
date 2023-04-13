package com.github.slo0ey.kwe.model

import org.jetbrains.exposed.sql.Table

object User: Table() {
    val id = long("id").autoIncrement()
    val name = varchar("name", 24)
    val age = integer("age")
    val gender = enumeration("gender", Gender::class)
    override val primaryKey = PrimaryKey(id)
}

enum class Gender {
    MALE, FEMALE
}