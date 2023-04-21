package com.github.slo0ey.kwe.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserDeleteRequest(
    val id: Int
)
