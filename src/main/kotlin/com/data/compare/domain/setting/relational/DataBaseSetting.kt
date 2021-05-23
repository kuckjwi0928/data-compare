package com.data.compare.domain.setting.relational

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("database_setting")
data class DataBaseSetting(
    @Id
    val id: Long
)
