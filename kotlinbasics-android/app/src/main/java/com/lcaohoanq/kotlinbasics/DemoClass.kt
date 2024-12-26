package com.lcaohoanq.kotlinbasics

import java.time.LocalDateTime
import java.util.UUID

fun main() {

    println("Hello from DemoClass")
    println(Student("Amit", 20))

}

class Student(private var name: String, private var age: Int) {

    override fun toString(): String {
        return "Student(name='$name', age=$age)"
    }
}

class BaseEntity(
    private var id: UUID,
    private var createdAt: LocalDateTime,
    private var updatedAt: LocalDateTime
)

interface Walkable {
    fun walk()
}