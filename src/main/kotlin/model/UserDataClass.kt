package com.lcaohoanq.model

data class UserDataClass(
    val name: String,
    val age: Int,
)

fun main(args: Array<String>) {
    val user = UserDataClass("John Doe", 30)
    println("Name: ${user.name}, Age: ${user.age}")

    println("User data from toString() method: $user")
}

// difference between data class and class
// data class has toString(), equals(), hashCode(), copy() methods... inside
// class are not
