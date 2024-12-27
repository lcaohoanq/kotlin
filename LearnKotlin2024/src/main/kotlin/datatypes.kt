fun getDataType() {

    println("Hello world")
    var x = 5 //this is a variable
    var m: Int = 120
    println("x is : $x, a = $m")
    //you can change value of a variable
    x = 6
    println("x now is : $x")
    val y = 44 //val = cannot be assigned
    //y = 55
    //function = a block of code
    sayHello("Hoang")
    println("sum 2 and 3 is : ${sum(2.0, 3.0)}")
    //you can use labeled arguments
    println("sum 4 and 5 is : ${sum(x = 4.0, y = 5.0)}")
    
    // Data types
    val a: Int = 10000
    val d: Double = 100.00
    val f: Float = 100.00f
    val l: Long = 1000000004
    val s: Short = 10
    val b: Byte = 1
    val isExistingUser: Boolean = true
    val c: Char = 'a'
    println("Your Int Value is $a")
    println("Your Double  Value is $d")
    println("Your Float Value is $f")
    println("Your Long Value is $l")
    println("Your Short Value is $s")
    println("Your Byte Value is $b")
    println("Your Boolean Value is $isExistingUser")
    println("Your Char Value is $c")

    // Unsigned integer types: UByte(8), UShort(16), UInt(32), ULong(64)
    // Min value are 0
    // Utilizing the full bit range of an integer to represent positive values.

    val hoang: Any? = null //nullable type
    val hehe: Any = "Hello world!!!"
    if (hehe is Any)
        if (hehe is String) println("hehe is String") else println("hehe is not String")
    else println("hehe is null")

    /*
    Unit: A function that returns no meaningful value but still completes normally.
    Nothing: A function that never returns a value because it either throws an exception 
    or doesn't terminate normally.
    */
    
}

// Can also omit the return type since `Unit` is implied
fun sayHelloV2(): Unit {
    println("Hello, World!")
}

// Used for functions that terminate abnormally
fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}

fun process(value: Int?) {
    val nonNullValue = value ?: fail("Value cannot be null")
    println(nonNullValue)
}

