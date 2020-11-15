package com.duberton.com.duberton.application.port

import com.duberton.com.duberton.application.domain.Record

interface RecordRepositoryPort {

    suspend fun save(record: Record): Record
}