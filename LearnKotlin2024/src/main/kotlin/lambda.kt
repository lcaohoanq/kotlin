/*
lambda expression: 
- Function which has no name
- Are function literals, i.e. functions that are not declared, but passed immediately as an expression 
- Are defined with curly braces {} which takes variables as a parameter (if any) and a body of a function
- The body of a lambda is written after the variable (if any) followed by -> operator
- Syntax: { variable -> body_of_lambda }
*/

fun main(){
    val sum: (Int, Int) -> Int = { a: Int, b: Int -> a + b }
    print(sum(5, 6))
    
    //shorter
    val sum2 = { a: Int, b: Int -> println(a+b) }
    print(sum2(5, 6))
}

fun addNumber( a: Int, b: Int) {
    val sum = a + b
    print(sum)
}


