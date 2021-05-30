package com.data.compare.handler

import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse

interface BaseHandler {
    suspend fun save(request: ServerRequest): ServerResponse
    suspend fun find(request: ServerRequest): ServerResponse
    suspend fun findAll(request: ServerRequest): ServerResponse
}
