package com.duberton.com.duberton.adapter.output.mongo.ext

import com.duberton.com.duberton.adapter.output.mongo.entity.RecordEntity
import com.duberton.com.duberton.application.domain.Record

fun Record.toEntity() = RecordEntity(
    artist = artist,
    album = album,
    createdAt = createdAt,
    updatedAt = updatedAt
)

fun RecordEntity.toDomain() = Record(
    artist = artist!!,
    album = album!!,
    createdAt = createdAt!!,
    updatedAt = updatedAt
)