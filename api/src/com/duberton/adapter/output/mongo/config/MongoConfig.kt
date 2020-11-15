package com.duberton.com.duberton.adapter.output.mongo.config

import com.duberton.com.duberton.adapter.output.mongo.RecordRepository
import com.duberton.com.duberton.application.port.RecordRepositoryPort
import com.typesafe.config.ConfigFactory
import io.ktor.config.*
import io.ktor.util.*
import org.koin.dsl.bind
import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

@KtorExperimentalAPI
val mongoModule = module {
    single { RecordRepository(get()) } bind RecordRepositoryPort::class
    single {
        val hoconApplicationConfig = HoconApplicationConfig(ConfigFactory.load())
        val mongoHost = hoconApplicationConfig.property("ktor.mongo.host").getString()
        val mongoPort = hoconApplicationConfig.property("ktor.mongo.port").getString()
        KMongo.createClient("mongodb://$mongoHost:$mongoPort").coroutine.getDatabase("record")
    }
}