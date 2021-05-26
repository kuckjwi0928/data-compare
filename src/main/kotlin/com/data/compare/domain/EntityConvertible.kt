package com.data.compare.domain

interface EntityConvertible<T> {
    fun toEntity(): T
}
