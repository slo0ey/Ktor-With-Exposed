package com.github.slo0ey.kwe.router

import com.github.slo0ey.kwe.dto.UserCreateRequest
import com.github.slo0ey.kwe.usecase.CreateUserUseCase
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.routing.*

fun Routing.userRouter() = route("user") {
    post("create") {
        val request = call.receive<UserCreateRequest>()
        CreateUserUseCase().create(request)
    }
}