package com.duberton.com.duberton.adapter.input.web.ext

import com.duberton.com.duberton.adapter.input.web.request.RecordRequest
import com.duberton.com.duberton.adapter.input.web.response.RecordResponse
import com.duberton.com.duberton.application.domain.Record
import java.time.LocalDateTime

fun RecordRequest.toDomain() = Record(
    artist = artist,
    album = album,
    createdAt = LocalDateTime.now().toString()
)

fun Record.toResponse() = RecordResponse(
    artist = artist,
    album = album,
    createdAt = createdAt,
    updatedAt = updatedAt
)