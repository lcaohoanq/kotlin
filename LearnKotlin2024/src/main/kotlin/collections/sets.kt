package collections

fun main(){
    
    val fruits = setOf("guava", "strawberry", "kiwi", "pear", "kiwi")
    println(fruits)
    println(fruits.contains("kiwi"))
    println(fruits.elementAt(2))
    println(fruits.elementAtOrNull(5))
    println(fruits.first())
    println(fruits.last())
    println(fruits.size)
    println(fruits.toSortedSet())
    println(fruits.sorted())
    println(fruits.shuffled())
    println(fruits.reversed())
    println(fruits.isEmpty())
    println(fruits.isNotEmpty())
    
    val mutableFruits = mutableSetOf("guava", "strawberry", "kiwi", "pear", "kiwi")
    mutableFruits.add("apple")
    mutableFruits.remove("kiwi")
    println(mutableFruits)
    
    //immutable list
    val newFruits = fruits.toMutableList()
    newFruits.add("apple")
    newFruits.remove("kiwi")
    println(newFruits)
    
}