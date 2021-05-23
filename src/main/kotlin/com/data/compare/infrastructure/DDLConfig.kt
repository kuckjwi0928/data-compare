package com.data.compare.infrastructure

import io.r2dbc.spi.ConnectionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator

@Configuration
class DDLConfig {
    @Bean
    fun initializer(connectionFactory: ConnectionFactory): ConnectionFactoryInitializer {
        val initializer = ConnectionFactoryInitializer()
        initializer.setConnectionFactory(connectionFactory)
        initializer.setDatabasePopulator(
            CompositeDatabasePopulator(
                listOf(
                    ResourceDatabasePopulator(ClassPathResource("schema.sql")),
                    ResourceDatabasePopulator(ClassPathResource("data.sql"))
                )
            )
        )
        return initializer
    }
}
