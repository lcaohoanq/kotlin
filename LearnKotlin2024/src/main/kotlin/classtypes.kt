/* 
Class with primary constructor,
do not require initialize the properties with default values 
*/
class User(
    val id: String,
    val name: String
) {
    override fun toString(): String {
        return "User(id=$id, name=$name)"
    }
}

class User2() {
    var id: String? = null
    var name: String? = null

    override fun toString(): String {
        return "User2(id=$id, name=$name)"
    }
}

abstract class Person {
    abstract val id: String
    abstract val name: String
    abstract fun sayHello()
}

// nested class
class School {
    data class Student(
        val id: String,
        val name: String
    )
}

data class Student(
    val id: String,
    val name: String? = "John"
)

// enum class without properties
enum class Status { ACTIVE, INACTIVE }

// enum class with properties
enum class ActivityStatus(val status: String) {
    ACTIVE("active"),
    INACTIVE("inactive"),
}

fun main() {
    val user = User("1", "John")
    val student = Student("2", null)

    var (_, name) = student // Destructuring declaration, omit first element is id
    
    // In User2 class cannot init properties with the value pass in the constructor
    // So we have to use apply function to init properties
    // require var (have setter) properties
    val user2 = User2().apply {
        id = "3"
        name = "Doe"
    }

    println(user)
    println(student)
    println(user2)

}