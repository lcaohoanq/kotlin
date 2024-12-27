package collections

import Student

fun main(){
    
    //what is the difference between ArrayList<T> and mutableListOf<T>?
    //ArrayList<T> is a class, mutableListOf<T> is a function that returns a MutableList<T>
    //result are the same
    
    val fruits = mutableListOf("guava", "strawberry", "kiwi", "pear", "kiwi")
    
    val student: ArrayList<Student> = arrayListOf(Student("1", "Brown"), Student("2", "Smith"))
    
    val newStudent = ArrayList<Student>()
    newStudent.add(Student("1", "Brown"))
    newStudent.add(Student("2", "Smith"))
    
}