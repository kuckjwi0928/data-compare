package com.data.compare.domain.setting.relational

import com.data.compare.domain.setting.types.DatabaseType
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("database_setting")
data class DataBaseSetting(
    @Id
    val id: Long,
    val type: DatabaseType,
    val host: String,
    val username: String,
    val password: String,
)
