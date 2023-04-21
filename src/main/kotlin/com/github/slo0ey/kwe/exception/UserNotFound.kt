package com.github.slo0ey.kwe.exception

class UserNotFound(private val wrongId: Int): RuntimeException() {
    override val message: String
        get() = "UserNotFound [UserId: $wrongId]"
}