package com.github.slo0ey.kwe.usecase

import com.github.slo0ey.kwe.database.dao.UserDAO
import com.github.slo0ey.kwe.database.util.dbQuery
import com.github.slo0ey.kwe.dto.UserCreateRequest

class CreateUserUseCase {
    suspend fun create(request: UserCreateRequest) {
        dbQuery {
            UserDAO.new {
                name = request.name
                age = request.age
                gender = request.gender
            }
        }
    }
}