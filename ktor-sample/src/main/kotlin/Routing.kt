package com.lcaohoanq

import io.ktor.server.application.*
import io.ktor.server.plugins.swagger.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

fun Application.configureRouting() {
    var accountList = mutableListOf<User>()
    accountList.add(
        User(username = "lcaohoanq", password = "123456", email = "example@gmail.com", age = 20),
    )
    
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        
        get("/users") {
            call.respond(accountList)
        }
        
        post<LoginDTO> {
            val loginDTO = call.receive<LoginDTO>()
            call.respondText("Username: ${loginDTO.username}, Password: ${loginDTO.password}")
        }
        
        post<User> {
            val user = call.receive<User>()
            accountList.add(user)
            call.respondText("New User register successfully!")
        }

        swaggerUI(path = "swagger", swaggerFile = "openapi/documentation.yaml")
    }
}

@Serializable
data class LoginDTO(val username: String, val password: String)

@Serializable
data class User(val username: String, val password: String, val email: String, val age: Int)