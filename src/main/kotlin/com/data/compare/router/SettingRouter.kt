package com.data.compare.router

import com.data.compare.handler.SettingHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class SettingRouter {
    @Bean
    fun router(settingHandler: SettingHandler) = coRouter {
        accept(APPLICATION_JSON).nest {
            path("/api/settings").nest {
                GET("", settingHandler::findAll)
                GET("{id}", settingHandler::find)
                POST("", settingHandler::save)
                PUT("{id}", settingHandler::save)
            }
        }
    }
}
