import collections.immutableList

fun main(){
    loops()
    
    //looping through a list
    immutableList()
}

fun loops(){
    
    for(num in 1..10){
        println(num)
    }
    
    for (i in 1 until 10) {
        println(i)
    }
    
    for (i in 10 downTo 1) {
        println(i)
    }
    
    for (i in 1..10 step 2) {
        println(i)
    }
    
    for (i in 10 downTo 1 step 2) {
        println(i)
    }
    
}