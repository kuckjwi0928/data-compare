package com.data.compare.extension

import kotlinx.coroutines.flow.Flow
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyAndAwait
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.buildAndAwait

suspend fun okOrNotFound(flow: Flow<Any>): ServerResponse {
    return if (flow.isEmpty()) ServerResponse.notFound().buildAndAwait()
        else ServerResponse.ok().bodyAndAwait(flow)
}

suspend fun okOrNotFound(value: Any?): ServerResponse {
    value?.let {
        return ServerResponse.ok().bodyValueAndAwait(it)
    }
    return ServerResponse.notFound().buildAndAwait()
}
