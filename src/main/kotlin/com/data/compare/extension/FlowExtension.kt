package com.data.compare.extension

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull

suspend fun Flow<Any>.isEmpty(): Boolean {
    firstOrNull()?.let {
        return false
    }
    return true
}
