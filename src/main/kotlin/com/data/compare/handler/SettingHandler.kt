package com.data.compare.handler

import com.data.compare.domain.setting.repository.DataBaseSettingRepository
import com.data.compare.extension.okOrNotFound
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse

@Component
class SettingHandler(private val dataBaseSettingRepository: DataBaseSettingRepository) {
    suspend fun findAll(request: ServerRequest): ServerResponse {
        return okOrNotFound(dataBaseSettingRepository.findAll())
    }
}
