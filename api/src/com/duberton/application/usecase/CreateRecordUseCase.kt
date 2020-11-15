package com.duberton.com.duberton.application.usecase

import com.duberton.com.duberton.application.domain.Record
import com.duberton.com.duberton.application.port.CreateRecordPort
import com.duberton.com.duberton.application.port.RecordRepositoryPort

class CreateRecordUseCase(private val recordRepositoryPort: RecordRepositoryPort) : CreateRecordPort {

    override suspend fun create(record: Record): Record {
        return with(record) {
            save(recordRepositoryPort)
            record
        }
    }
}