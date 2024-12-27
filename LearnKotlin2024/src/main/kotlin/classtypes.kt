import com.sun.org.apache.bcel.internal.generic.NEW
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

// nested class: in Kotlin, nested class is static by default, 
// so its data member and member function can be accessed without creating an object of the class
// nested class cannot access the outer class's members
class School {
    data class Student(
        val id: String,
        val name: String
    )
}

// inner class: nested class which is marked as "inner" is called inner class
// the advantages is inner class can access the outer class's members even if it is private
class School2 {
    
    private val schoolName = "ABC School"
    
    inner class Student(
        val id: String,
        val name: String
    ){
        fun createStudent(){
            var student = Student("1", "John")
            println("""
                |Student: ${student.id}
                |Name: ${student.name}
                |School: $schoolName
            """.trimMargin())
        }
    }
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
    
    //define an object from class
    val user1 = models.User(1, "hoang", "sunlight4d@gmail.com")
    val duong = models.User(1, "hoang", "sunlight4d@gmail.com")
    //2 data objects with the same values => the same hashcode
    println(user1.hashCode())
    println(duong.hashCode())
    if (user1.equals(duong)) {
        println("user1 and duong has the same content")
    }
    user1.name = "John"
    println(user1) //you can change property's value of a "val" object
    //but you cannot reference to another object / cannot be reassigned
    //user1 = User(2, "tony", "tony@gmail.com")
    val user3 = models.User(3, "mary", "mary@gmail.com")
    //clone this object
    //val user4 = user3.copy()
    //clones and changes properties
    val user4 = user3.copy(email = "mary123@gmail.com")
    println(user3)
    println(user4)
    
}