import models.Bicycle
import models.Car
import models.Vehicle

fun main(){
    myFunction(5) //10

    // infix functions
    val z = 12 plus 5
    println("z = $z")
    println("5 + 3 is : ${5 plus 3}")
    println("6 times 5 = ${6 times 5}")
    var message: String = "John" loves "Mary" //non-null type String
    //message = null
    println(message)

    showColor(255, 0, 0, 0.5f) //double not need f suffix
    like("apple", "orange", "pineapple", "kiwi")

    /*
    doSomething(1, 2, completion = {result:Int -> run {
        println("result is : $result")
    }})
     */
    //more simpler way
    /*
    doSomething(1, 3) {result:Int ->
        run {
            println("result is : $result")
        }
    }
    */
    //simplest way
    doSomething(2, 3) {
        println("result is: $it") //item
    }
    println("operation = ${operation(x = 10.0f)(20.0f)}")
    println("Full name = ${getFullName("Nguyen", "Duc Hoang")}")
    println(url(1, 200))
    println(squaredNumber(30))
    url(1, 200).let { //the let function is used to execute a block of code on a non-null object
        println("It means that url is NOT NULL")
        println(it) //default name of the object is "it", this will take the value is the return value of the previous function
        println("Do more ...")
    }
}

//shadowing function
fun myFunction(a: Int){
    val a = 10
    println(a) //10
    // pass a value to this function, but it is not used
    // the variable is shadowed by the local variable
}

//Void Function: Can be omitted the Unit return type
fun sayHello(name: String):Unit {
    println("Hello "+name)
}

fun sayHello2(name: String) {
    println("Hello $name") //string concatenation 
}

//functions which returns value
fun sum(x: Double, y: Double): Double {
    return x + y
}
fun showColor(red: Int, green: Int, blue: Int, alpha: Float) {
    println("color: $red - $green - $blue - $alpha")
}
//function with Variadic Arguments - vararg
fun like(vararg fruits: String) {
    for (fruit in fruits) {
        println("I like $fruit")
    }
}
//infix functions
//can be called without using the period and brackets
infix fun Int.plus(x: Int): Int {
    return this + x
}
infix fun Int.times(x: Int): Int = this * x //one-line function
infix fun String.loves(name: String) = "$this loves $name"
//Higher order function is:
//- function that takes another function as parameter
//OR - function returns a function
fun doSomething(x: Int, y: Int, completion: (Int) -> Unit) {
    println("do something")
    val result = x + y
    completion(result)
}
//function returns a function
fun operation(x: Float): (y:Float) -> Float {
    return fun(y: Float): Float {
        return y * y
    }
}
//lambda function
val getFullName:(String, String) -> String = {
        firstName: String, lastName:String -> run {
            println("This is a lambda function")
            "$firstName $lastName"
    }
}
//another example
val url:(Int, Int)->String = {
    page:Int, limit:Int ->
        "https://yourServerName:port/products?page=$page&limit=$limit"
}
//another simpler example
val squaredNumber:(Int) -> Int = {x -> x * x}
fun describeVehicle(vehicle: Vehicle):String {
    return when(vehicle) {
        is Bicycle -> "This is a bicycle"
        is Car -> "This is a Car"
        else -> "I don't know"
    }
}