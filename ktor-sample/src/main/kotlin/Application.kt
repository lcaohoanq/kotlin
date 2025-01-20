package com.lcaohoanq

import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.cors.routing.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureRouting()
    install(ContentNegotiation){
        json()
    }
    embeddedServer(Netty, port = 8080) {
        install(CORS){
            anyHost()
            allowHeader(HttpHeaders.ContentType)
        }
    }.start(wait = true)
}
