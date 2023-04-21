package com.github.slo0ey.kwe.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserCreateResponse(
    val id: Int
) {
    val message = "Successfully created"
}
