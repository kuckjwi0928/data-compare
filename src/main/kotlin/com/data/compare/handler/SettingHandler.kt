package com.data.compare.handler

import com.data.compare.domain.setting.model.DataBaseSettingUpsertRequest
import com.data.compare.domain.setting.repository.DataBaseSettingRepository
import com.data.compare.extension.okOrNotFound
import com.data.compare.extension.pathVariableOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*
import org.springframework.web.server.ResponseStatusException
import java.net.URI
import java.util.*

@Component
class SettingHandler(private val dataBaseSettingRepository: DataBaseSettingRepository) : BaseHandler {
    override suspend fun save(request: ServerRequest): ServerResponse {
        val upsertRequest = request.awaitBodyOrNull<DataBaseSettingUpsertRequest>()

        if (Objects.isNull(upsertRequest)) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST)
        }

        request.pathVariableOrNull("id")?.let {
            val entity = dataBaseSettingRepository.findById(it.toLong())
            if (Objects.isNull(entity)) {
                return ServerResponse.notFound()
                        .buildAndAwait()
            }
            return ServerResponse.ok()
                    .bodyValueAndAwait(dataBaseSettingRepository.save(entity!!.update(upsertRequest!!)))
        }

        val entity = dataBaseSettingRepository.save(upsertRequest!!.toEntity())
        return ServerResponse.created(URI.create("/" + entity.id)).buildAndAwait()
    }

    override suspend fun find(request: ServerRequest): ServerResponse {
        return okOrNotFound(dataBaseSettingRepository.findById(request.pathVariable("id").toLong()))
    }

    override suspend fun findAll(request: ServerRequest): ServerResponse {
        return okOrNotFound(dataBaseSettingRepository.findAll())
    }
}
