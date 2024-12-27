import com.sun.org.apache.xerces.internal.impl.dv.xs.IntegerDV

/*
    - Unchecked exceptions are exceptions that are not checked at compile-time
    - Checked exceptions are exceptions that are checked at compile-time

    try-catch-finally block
*/

/*
    In Java your functions are something like this
    
    void foo() throws IOException{
        throw new IOException();
    }
    In Kotlin, all exceptions are unchecked, meaning that the compiler does not force you to catch any of them
    But in Kotlin you can add annotation like below to force other Java classes to catch it. 
    However, as other answers have pointed out, it doesn't have any meaning among Kotlin classes.
    
    @Throws(IOException::class)
    fun foo() {
        throw IOException()
    }
*/

open class DataAlreadyExistException(message: String?) : RuntimeException(message)

class RoleAlreadyExistException(message: String?) : DataAlreadyExistException(message)

fun main() {
    //multiple catch blocks
    try {
        throw RoleAlreadyExistException("Role already exists")
    } catch (e: RoleAlreadyExistException) {
        println("Caught RoleAlreadyExistException")
    } catch (e: DataAlreadyExistException) {
        println("Caught DataAlreadyExistException")
    } catch (e: RuntimeException) {
        println("Caught RuntimeException")
    } finally {
        println("Finally block")
    }

//    val str = getNumber("10") //Works fine
    val str = getNumber("10.5") //Must pass a Double or Float instead
    println(str)

}

fun getNumber(str: String): Int {
    return try {
        Integer.parseInt(str)
    } catch (e: NumberFormatException) {
        0
    }
}

//nested try-catch block
fun nestedTryCatch() {
    try {
        try {
            throw IllegalArgumentException("Illegal argument")
        } catch (e: IllegalArgumentException) {
            println("Caught IllegalArgumentException")
        }
    } catch (e: RuntimeException) {
        println("Caught RuntimeException")
    }
}
