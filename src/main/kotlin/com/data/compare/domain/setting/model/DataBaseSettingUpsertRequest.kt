package com.data.compare.domain.setting.model

import com.data.compare.domain.EntityConvertible
import com.data.compare.domain.setting.relational.DataBaseSetting
import com.data.compare.domain.setting.types.DatabaseType

data class DataBaseSettingUpsertRequest(
    val type: DatabaseType,
    val host: String,
    val username: String,
    val password: String
) : EntityConvertible<DataBaseSetting> {
    override fun toEntity(): DataBaseSetting = DataBaseSetting(
        type = type, host = host, username = username, password = password
    )
}
