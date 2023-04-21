package com.github.slo0ey.kwe.router

import com.github.slo0ey.kwe.database.dao.UserDAO
import com.github.slo0ey.kwe.database.util.dbQuery
import com.github.slo0ey.kwe.dto.UserCreateRequest
import com.github.slo0ey.kwe.dto.UserCreateResponse
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Routing.userRouter() = route("user") {
    post("create") {
        val request = call.receive<UserCreateRequest>()
        dbQuery {
            UserDAO.new {
                name = request.name
                age = request.age
                gender = request.gender
            }
        }.run {
            call.respond(UserCreateResponse(id.value))
        }
    }
}