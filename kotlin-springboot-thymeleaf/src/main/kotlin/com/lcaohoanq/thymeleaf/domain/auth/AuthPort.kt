package com.lcaohoanq.thymeleaf.domain.auth

interface AuthPort {

    data class LoginRequest(
        val username: String = "-1",
        val password: String = "-1"
    )

    data class RegisterRequest(
        val username: String = "aclice@example.com",
        val password: String = "123123"
    )

}