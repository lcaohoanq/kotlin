fun immutableList() {
    // Immutable list
    val fruits = listOf("Apple", "Banana", "Cherry")

    // Accessing elements
    println(fruits) //[Apple, Banana, Cherry]
    println("First fruit: ${fruits[0]}, Second fruit: ${fruits[1]}")  // Output: First fruit: Apple
//    fruits[2] = "Orange"  // Error: Cannot modify elements in an immutable list

    fruits.listIterator().forEach { fruit -> print("$fruit, ") } //write in lambda

    fruits.listIterator(0).forEach { fruit -> print("$fruit, ") } //write in lambda

    fruits.forEach { fruit -> print("$fruit, ") } //write in lambda

    // Iterating over the list
    for (fruit in fruits) {
        print("""
            $fruit, 
        """.trimIndent())
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

    // Modifying elements
    vegetables[0] = "Cucumber"
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