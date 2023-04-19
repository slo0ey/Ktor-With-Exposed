package com.github.slo0ey.kwe.database.util

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.Transaction
import org.jetbrains.exposed.sql.transactions.transaction

suspend fun <T> dbQuery(query: Transaction.() -> T): T = withContext(Dispatchers.IO) {
    transaction {
        query()
    }
}