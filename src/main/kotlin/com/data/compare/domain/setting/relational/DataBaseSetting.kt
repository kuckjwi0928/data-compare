package com.data.compare.domain.setting.relational

import com.data.compare.domain.Updatable
import com.data.compare.domain.setting.model.DataBaseSettingUpsertRequest
import com.data.compare.domain.setting.types.DatabaseType
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("database_setting")
data class DataBaseSetting(
    @Id
    var id: Long = 0,
    var type: DatabaseType,
    var host: String,
    var username: String,
    var password: String,
    @CreatedDate
    @Column("created_at")
    var createdAt: LocalDateTime? = null,
    @LastModifiedDate
    @Column("updated_at")
    var updatedAt: LocalDateTime? = null
) : Updatable<DataBaseSetting, DataBaseSettingUpsertRequest> {
    override fun update(param: DataBaseSettingUpsertRequest): DataBaseSetting {
        val (type, host, username, password) = param
        return this.copy(type = type, host = host, username = username, password = password)
    }
}
