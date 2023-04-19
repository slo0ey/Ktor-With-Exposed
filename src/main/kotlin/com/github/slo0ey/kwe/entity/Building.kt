package com.github.slo0ey.kwe.entity

data class Building(
    val id: Long,
    val name: String,
    val owner: User,
    val location: City,
    val tenants: Int
)
