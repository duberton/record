package com.duberton.com.duberton.application.port

import com.duberton.com.duberton.application.domain.Record

interface CreateRecordPort {

    suspend fun create(record: Record): Record

}