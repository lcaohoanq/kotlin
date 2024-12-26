package com.lcaohoanq.kotlinbasics

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.util.UUID

@RequiresApi(Build.VERSION_CODES.O)
fun main() {
    val student = StudentV2("Amit", 20, UUID.randomUUID(), LocalDateTime.now(), LocalDateTime.now())
    println(student.toString())
    student.walk()
}

class StudentV2(
    private var name: String,
    private var age: Int,
    id: UUID,
    createdAt: LocalDateTime,
    updatedAt: LocalDateTime
) : BaseEntityV2(id, createdAt, updatedAt), WalkableV2 {

    override fun toString(): String {
        return "Student(name='$name', age=$age, id=$id, createdAt=$createdAt, updatedAt=$updatedAt)"
    }

    override fun walk() {
        println("$name is walking")
    }
}

open class BaseEntityV2(
    protected var id: UUID,
    protected var createdAt: LocalDateTime,
    protected var updatedAt: LocalDateTime
)

interface WalkableV2 {
    fun walk()
}
