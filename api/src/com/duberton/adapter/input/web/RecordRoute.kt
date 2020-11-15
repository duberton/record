package com.duberton.com.duberton.adapter.input.web

import com.duberton.com.duberton.adapter.input.web.ext.toDomain
import com.duberton.com.duberton.adapter.input.web.ext.toResponse
import com.duberton.com.duberton.adapter.input.web.request.RecordRequest
import com.duberton.com.duberton.application.port.CreateRecordPort
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Routing.records() {

    val createRecordPort: CreateRecordPort by inject()

    route("/v1/record") {
        post {
            val recordRequest = call.receive<RecordRequest>()
            val record = createRecordPort.create(recordRequest.toDomain())
            call.respond(HttpStatusCode.Created, record.toResponse())
        }
    }
}