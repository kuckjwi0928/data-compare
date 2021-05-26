package com.data.compare.handler

import com.data.compare.domain.setting.model.DataBaseSettingCreateRequest
import com.data.compare.domain.setting.repository.DataBaseSettingRepository
import com.data.compare.extension.okOrNotFound
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.awaitBodyOrNull
import org.springframework.web.reactive.function.server.buildAndAwait
import org.springframework.web.server.ResponseStatusException
import java.net.URI

@Component
class SettingHandler(private val dataBaseSettingRepository: DataBaseSettingRepository) {
    suspend fun save(request: ServerRequest): ServerResponse {
        val createRequest = request.awaitBodyOrNull<DataBaseSettingCreateRequest>()

        createRequest?.let {
            dataBaseSettingRepository.save(it.toEntity())
            return ServerResponse.created(URI.create("TODO")).buildAndAwait()
        }

        throw ResponseStatusException(HttpStatus.BAD_REQUEST)
    }

    suspend fun findAll(request: ServerRequest): ServerResponse {
        return okOrNotFound(dataBaseSettingRepository.findAll())
    }
}
