import java.util.UUID

//can omit the public constructor keyword
class Song public constructor(id: String, name: String) {
    val id: String = id
    val name: String = name
}

class Film private constructor(id: String, name: String) {
    var id: String = id
    val name: String = name
}

// open class can be inherited
open class Book protected constructor(id: String, name: String) {
    val id: String = id
    val name: String = name
}

class Lamp internal constructor(id: String, name: String) {
    val id: String = id
    val name: String = name
}

/* 
Class with primary constructor,
do not require initialize the properties with default values 
*/
class User(
    val id: String = UUID.randomUUID().toString(),
    val name: String = "Unknown"
) {
    var hobby: String? = null
        //custom getter, setter
        get() {
            println("get() is called")
            return field?.uppercase()
        }
        set(value) {
            field = if (value.isNullOrBlank()) "unknown" else value
        }

    var age: Int? = null
        private set

    lateinit var email: String //lateinit property must be var and cannot be nullable

    //initialize block
    init {
        println("User is created with id: $id, name: $name")
//        email = "hoang@gmail.com"
    }

    override fun toString(): String {
        return "User(id=$id, name=$name)"
    }

    //member constructor
    constructor(id: String, name: String, hobby: String, age: Int) : this(id, name) {
        this.hobby = hobby
        this.age = age
    }

    //member function
    fun stateHobby() {
        println("$name's hobby is $hobby")
    }

    fun stateAge() {
        println("$name's age is $age")
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
    val id: String? = UUID.randomUUID().toString(),
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

    val mnhw = User(
        name = "mnhw.0612",
//        id = UUID.randomUUID().toString()

    ) //named arguments
    mnhw.hobby = "Learning English"
    //mnhw.age = 18 //Compile error, because age is private set
    //mnhw.email : kotlin.UninitializedPropertyAccessException: lateinit property email has not been initialized 
    mnhw.stateHobby()

    val ybjoow = User("2", "ybjow", "Learning Chinese", 20)
    ybjoow.stateHobby()

    val hoang = User() //cannot use this, until we pass the default value to the constructor
    val student = Student("2", null)
    val student2 = student.copy(id = "new_clone", name = "Doe")

    var (_, name) = student // Destructuring declaration, omit first element is id
    //require exactly the same name and order of the properties within the class
    // var(name, _) = student //Compile error
    println("Destructuring name: $name")

    // In User2 class cannot init properties with the value pass in the constructor
    // So we have to use apply function to init properties
    // require var (have setter) properties
    val user2 = User2().apply {
        id = "3"
        name = "Doe"
    }

    println(user)
    println(mnhw)
    println(hoang)
    println(student)

    println(student2)
    println(student2.component1())
    println(student2.component2())
    //destructuring
    var (id, name2) = student2
    println("id= $id, name= $name2")

    println(user2)

    //Cannot access '<init>': it is private in 'Film'
    //val film: Film = Film("1", "The Avengers")
    var film: Film? = null
    film?.let {
        with(film) {
            id = "1"
            name = "The Avengers"
        }
    }

}