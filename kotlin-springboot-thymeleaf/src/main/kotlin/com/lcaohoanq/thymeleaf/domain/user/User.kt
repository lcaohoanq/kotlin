package com.lcaohoanq.thymeleaf.domain.user

import java.util.UUID

data class User(
    var id: UUID,
    var username: String,
    var hashedPassword: String
)
