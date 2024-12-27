package collections

import Student

fun main() {

    val daysOfTheWeek = mapOf(
        1 to "Monday",
        2 to "Tuesday",
        3 to "Wednesday",
        4 to "Thursday",
        5 to "Friday",
        6 to "Saturday",
        7 to "Sunday"
    )
    
    println(daysOfTheWeek)
    println(daysOfTheWeek[2])
    daysOfTheWeek.forEach(::println)
    println(daysOfTheWeek.toSortedMap())
    
    for(key in daysOfTheWeek.keys){
        println("key: $key, value: ${daysOfTheWeek[key]}")
    }
    
    for((key, value) in daysOfTheWeek) {
        println("key: $key, value: $value")
    }
    
    for(entry in daysOfTheWeek.entries) {
        println("key: ${entry.key}, value: ${entry.value}")
    }
    
    daysOfTheWeek.forEach { (i, s) ->  
        println("key: $i, value: $s")
    }
    
    val studentList = mapOf(
        "1" to Student("1", "Brown"),
        "2" to Student("2", "Smith"),
        "3" to Student("3", "Johnson")
    )
    
    val newDaysOfTheWeek = daysOfTheWeek.toMutableMap()
    newDaysOfTheWeek[8] = "New Day"

}