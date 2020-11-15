package com.duberton.com.duberton.adapter.output.mongo

import com.duberton.com.duberton.adapter.output.mongo.entity.RecordEntity
import com.duberton.com.duberton.adapter.output.mongo.ext.toEntity
import com.duberton.com.duberton.application.domain.Record
import com.duberton.com.duberton.application.port.RecordRepositoryPort
import org.litote.kmongo.coroutine.CoroutineDatabase

class RecordRepository(private val mongoDatabase: CoroutineDatabase) : RecordRepositoryPort {

    private val recordCollection = mongoDatabase.getCollection<RecordEntity>("record")

    override suspend fun save(record: Record): Record {
        recordCollection.insertOne(record.toEntity())
        return record
    }
}