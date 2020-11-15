package com.duberton.com.duberton.application.domain

import com.duberton.com.duberton.application.port.RecordRepositoryPort

data class Record(
    val artist: String,
    val album: String,
    val createdAt: String,
    val updatedAt: String? = null
) {

    suspend fun save(recordRepositoryPort: RecordRepositoryPort) {
        recordRepositoryPort.save(this)
    }

}