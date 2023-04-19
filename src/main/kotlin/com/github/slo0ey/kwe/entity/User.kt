package com.github.slo0ey.kwe.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Long,
    val name: String,
    val age: Int,
    val gender: Gender
) {
    @Serializable
    enum class Gender {
        @SerialName("MALE") MALE,
        @SerialName("FEMALE") FEMALE
    }
}