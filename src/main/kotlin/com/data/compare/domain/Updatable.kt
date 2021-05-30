package com.data.compare.domain

interface Updatable<T, P> {
    fun update(param: P): T
}
