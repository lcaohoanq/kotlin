package collections/*
    Immutable List: list of elements that cannot be modified
    - listOf: create an immutable list
    - Access elements using indexing
    - Iterate over the list using for loop, forEach, listIterator
   
    Mutable List: list of elements that can be modified
    - mutableListOf: create a mutable list
    - Manipulate elements using add, remove, and set
    - Iterate over the list using for loop, forEach, listIterator
*/

import models.Car

fun immutableList() {
    val fruits = listOf("Apple", "Banana", "Cherry")

    val anyTypes: List<Any> = listOf(1, 2, "hello", 3.0, Car("GLB 200 7G-DCT", 82020, 1.3f, 163), true)
    println(anyTypes.size)
    println(anyTypes)

    // Accessing elements
    println(fruits) //[Apple, Banana, Cherry]
    println("First fruit: ${fruits[0]}, Second fruit: ${fruits[1]}")  // Output: First fruit: Apple
//    fruits[2] = "Orange"  // Error: Cannot modify elements in an immutable list

    fruits.listIterator().forEach { fruit -> print("$fruit, ") } //write in lambda

    fruits.listIterator(0).forEach { fruit -> print("$fruit, ") } //write in lambda

    fruits.forEach { fruit -> print("$fruit, ") } //write in lambda

    // Iterating over the list
    for (fruit in fruits) {
        print(
            """
            $fruit, 
        """.trimIndent()
        )
    }

    // Checking if the list contains a specific element
    if ("Banana" in fruits) {
        println("Banana is in the list!")
    }

    /*
    listIterator(): Creates a list iterator for the list, allowing bidirectional iteration. Using forEach with listIterator() isn’t much different from iterating over the list itself, unless you need advanced iterator features.
    One common use case of ListIterator is when you need to move in both directions (i.e., forward and backward) through a list and maybe modify the elements while iterating
    listIterator(0): Same as listIterator(), but explicitly starts at index 0. This is redundant if you just want to iterate from the start.
    forEach: Directly iterates over the list in a concise and functional style. This is the most idiomatic approach in Kotlin for simple iteration.
    Traditional for loop: Standard iteration syntax, useful when you want more control (like using break or continue).
    */

    val iterator = fruits.listIterator()
    // Traverse forward through the list
    println("Traversing forward:")
    while (iterator.hasNext()) {
        val fruit = iterator.next()
        println(fruit)
    }

    // Traverse backward through the list
    println("\nTraversing backward:")
    while (iterator.hasPrevious()) {
        val fruit = iterator.previous()
        println(fruit)
    }

    println("Demo listIterator with specific index")
    fruits.listIterator(2).forEach { fruit -> print("$fruit, ") } //Output: Cherry, 
    //fruits.listIterator(8).forEach { fruit -> print("$fruit, ") } 
    /*
        Exception in thread "main" java.lang.IndexOutOfBoundsException: Index: 8, Size: 3
        at java.base/java.util.AbstractList.rangeCheckForAdd(AbstractList.java:632)
        at java.base/java.util.AbstractList.listIterator(AbstractList.java:338)
        at ListsKt.immutableList(lists.kt:51)
        at MainKt.main(main.kt:160)
        at MainKt.main(main.kt)
	*/
}

fun mutableList() {
    // Mutable list: elements can be added, removed, or modified
    val vegetables = mutableListOf("Carrot", "Broccoli", "Spinach")

    // Adding elements
    vegetables.add("Potato")
    vegetables.add(1, "Tomato")  // Insert at a specific index
    vegetables.addAll(listOf("Cabbage", "Lettuce"))  // Add multiple elements

    // Modifying elements
    /*
        The val keyword ensures that vegetables will always point to the same list object, 
        meaning you cannot reassign vegetables to a different list or object.However, since mutableListOf creates a mutable list,
        the contents of the list can be changed. You can add, remove, or modify elements within the list without changing the reference itself.
    */
    vegetables[0] = "Cucumber"
    vegetables.removeAt(2)  // Remove element at index 2
    //vegetables.removeAll(vegetables) //[] 
    println("Demo shuffle")
    vegetables.shuffle()  // Shuffle the elements
    println(vegetables)

    // Removing elements
    vegetables.remove("Spinach")
    vegetables.removeAt(2)  // Remove element at index 2

    // Iterating over the mutable list
    for (vegetable in vegetables) {
        println(vegetable)
    }

    vegetables.forEach(::println)
//    vegetables.forEach { println(ed) }
    vegetables.forEach { it -> println(it) }
    vegetables.forEach { println(it) } //it is default name of lambda parameter

    var someNumbers = mutableListOf<Int>(1, 3, 4, -2, 5, -3, 7)
    someNumbers.forEach {
        print("$it ")
    }
    if (someNumbers.any { it < 0 }) {
        println("At least 1 item is negative")
    }
    if (someNumbers.all { it < 100 }) {
        println("All items are < 100")
    }
    if (someNumbers.none { it == 100 }) {
        println("No item has value = 100")
    }
    val someFloats = mutableListOf<Float>(3.5f, 2.3f, 4.6f, 1.8f)
    someFloats[0] = 22.2f
    println(someFloats)
    var cars = mutableListOf<Car>(
        Car("GLB 200 7G-DCT", 82020, 1.3f, 163),
        Car("GLB 200 d 8G-DCT", 2020, 119f, 150),
        Car("Lexus CT200H F SPORT", 2014, 109.7f, 136),
        Car("Lexus CT200H Hybrid", 2018, 119f, 150),
        Car(
            "Jetta Advance 1.6 TDI 105HP BlueMotion Technology DSG 7",
            2011, 97.5f, 105
        ),
        Car("Jetta Sport 1.4 TSI 160HP DSG 7 speed", 2011, 84.8f, 160),
        Car("Bentley Flying Spur W12", 2013, 243.7f, 528),
        Car("Bentley Brooklands 2008", 2007, 412.6f, 537),
        Car("Continental GTC 6.0 W12", 2019, 363.1f, 635),
        Car("Qashqai DIG-T 158 4WD Auto", 2021, 81.3f, 158),
        Car("Nissan Laurel JC32 2.8 D", 2020, 172.5f, 90),
    )
    println(cars)
    println("Add 1 car to the first item")
    cars.add(0, Car("Nissan Murano Z50 3.5 (234HP)", 2004, 213.5f, 234))
    println("Add to the last item")
    cars.add(Car("Bentley 8 Litre", 1930, 487.2f, 230))
    cars.forEach {
        println(it)
    }
    //filter cars which year is between 2013 and 2016
    var filteredCars = cars.filter { it.year in 2013..2016 }
    //find cars which name contains "lexus"
    filteredCars = cars.filter { it.name.contains("lexus", ignoreCase = true) }
    println("filtered cars:")
    for (item in filteredCars) {
        println(item)
    }
    println("sort the list, by horsePower")
    //var sortedCars = cars.sortedBy { it.horsePower }
    val sortedCars = cars.sortedByDescending { it.horsePower }
    sortedCars.forEach {
        println(it)
    }
    //get car's name and add to a separated list
    val carNames = cars.map { it.name }
    carNames.forEach { println(it) }
    println("There are ${carNames.count()} cars")
    println("First name: ${carNames.first()}, last name: ${carNames.last()}")
    //split/partition a list
    var (newerCars, olderCars) = cars.partition { it.year > 2019 }
    //minimum, maximum
    println(cars.minOf { it.horsePower })
    println(cars.maxOf { it.horsePower })
}

fun listMixed() {
    val mixedList: List<Any> = listOf("Apple", 123, true, 45.67)

    // Iterating over a mixed-type list
    for (element in mixedList) {
        println(element)
    }

}

fun manipulationList() {
    val numbers = listOf(1, 2, 3, 4, 5)

// map: transform each element
    val doubled = numbers.map { it * 2 }
    println(doubled)  // Output: [2, 4, 6, 8, 10]

// filter: filter elements based on a condition
    val evens = numbers.filter { it % 2 == 0 }
    println(evens)  // Output: [2, 4]

// find: find the first element matching a condition
    val firstEven = numbers.find { it % 2 == 0 }
    println(firstEven)  // Output: 2

// reduce: combine all elements
    val sum = numbers.reduce { acc, num -> acc + num }
    println(sum)  // Output: 15

// sorted: sort the list
    val sortedNumbers = numbers.sortedDescending()
    println(sortedNumbers)  // Output: [5, 4, 3, 2, 1]

}

fun createEmptyList() {
    // Immutable empty list
    val emptyList = emptyList<String>()

    // Mutable empty list
    val mutableEmptyList = mutableListOf<String>()

    // Add elements to the mutable list
    mutableEmptyList.add("New Item")
    println(mutableEmptyList)  // Output: [New Item]

}

fun nestedList() {
    val listOfLists = listOf(
        listOf(1, 2, 3),
        listOf(4, 5, 6),
        listOf(7, 8, 9)
    )

// Accessing elements in a nested list
    println(listOfLists[0][1])  // Output: 2

// Iterating over a nested list
    for (sublist in listOfLists) {
        for (element in sublist) {
            println(element)
        }
    }

}

fun convertListType() {
    // Immutable list
    val immutableList = listOf("A", "B", "C")

    // Convert to mutable list
    val mutableList = immutableList.toMutableList()
    mutableList.add("D")

    // Convert back to immutable list
    val newImmutableList = mutableList.toList()

    println(newImmutableList)  // Output: [A, B, C, D]

}