package com.data.compare.domain.setting.repository

import com.data.compare.domain.setting.relational.DataBaseSetting
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface DataBaseSettingRepository : CoroutineCrudRepository<DataBaseSetting, Long> {
}
