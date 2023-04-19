package com.github.slo0ey.kwe.dto

import com.github.slo0ey.kwe.entity.User
import kotlinx.serialization.Serializable

@Serializable
data class UserCreateRequest(
    val name: String,
    val age: Int,
    val gender: User.Gender
)