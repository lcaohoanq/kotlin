/*Collections of only the same element
    - IntArray - Integer
    - DoubleArray - Double
    - LongArray - Long
    - ShortArray - Short
    - ByteArray - Byte
    - BooleanArray - Boolean

Collections of the same or different elements
    - arrayOf<String>
    - arrayOf<Int>
    - arrayOf<Fruit>
    - array(1,2,"Hoang", 3.0, Fruit())

Immutable Collections
    - listOf (List)
    - setOf (Set)
    - mapOf (Map)
    
Mutable Collections
    - arrayListOf, mutableListOf (MutableList) - ArrayList: java
    - hashSetOf, mutableSetOf (MutableSet) - HashSet: java
    - hashMapOf, mutableMapOf (MutableMap) - HashMap: java
*/

fun main() {

//    val numbers: IntArray = intArrayOf(1, 2, 3, 4, 5)
    val numbers: IntArray = intArrayOf(1, 2, 3, 4, 5)
    val numbers2 = IntArray(5) // [0, 0, 0, 0, 0]
    val numbers2_1: IntArray = IntArray(5) { 42 } // [42, 42, 42, 42, 42]
    val numbers2_2 = IntArray(5) { it * 2 } // [0, 2, 4, 6, 8]
    val numbers2_3 = IntArray(5) { (it + 1) * 2 } // [2, 4, 6, 8, 10]
    
    val numbers3: Array<Int> = arrayOf<Int>(1,2,4,6) //Integer[] in Java, boxed type, less memory efficient
    val numbers4 = arrayOf<Any>(1,"a", Student())

    println(numbers) // hashcode
    println(numbers.contentToString()) // [1, 2, 3, 4, 5]
    println(numbers[3]) // 4
    numbers[2] = 10
    //println(numbers[10]) // ArrayIndexOutOfBoundsException
    //numbers[10] = 10 // ArrayIndexOutOfBoundsException
    for(element in numbers) {
        println("element:  $element")
        println(" $element + 2") // 1 + 2 2 + 2 3 + 2 4 + 2 5 + 2
        println(" ${element + 2}") // 3 4 5 6 7
        //the value is changed only in the loop scope
    }
    numbers.forEach {
        print("$it ") // 1 2 3 4 5
    }
    
    numbers.forEachIndexed { index, value ->
        println("index: $index, value: $value")
    }
    
    /* indices: Returns an IntRange of the valid indices for this collection.
    
    indices returns IntRange(range of index from first to the last position) of collection, for example:
    val array= arrayOf(10,20,30,40,50,60,70)
    println("Indices: "+array.indices) // output: Indices: 0..6  
    */
    for(index in numbers.indices) {
        println("index: $index, value: ${numbers[index]}")
    }
    

}