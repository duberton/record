package com.duberton.com.duberton.adapter.input.web.config

import com.duberton.com.duberton.application.port.CreateRecordPort
import com.duberton.com.duberton.application.usecase.CreateRecordUseCase
import org.koin.dsl.bind
import org.koin.dsl.module

val apiModules = module {
    single { CreateRecordUseCase(get()) } bind CreateRecordPort::class
}