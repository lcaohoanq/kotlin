package com.lcaohoanq.model

data class UserDataClassWithAccessModifier(
    private val _name: String,
    val age: Int,
) {
    val name: String
        get() = _name
}

fun main(args: Array<String>) {
    val user = UserDataClassWithAccessModifier("John Doe", 30)
    println("Name: ${user.name}, Age: ${user.age}")

    println("User data from toString() method: $user")
}
