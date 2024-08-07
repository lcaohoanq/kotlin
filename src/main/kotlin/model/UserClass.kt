package com.lcaohoanq.model

class UserClass {

    val name: String = "John Doe"
    val age: Int = 30

    fun printUser() {
        println("Name: $name, Age: $age")
    }
}

fun main (args: Array<String>){
    val user = UserClass()
    user.printUser()
}