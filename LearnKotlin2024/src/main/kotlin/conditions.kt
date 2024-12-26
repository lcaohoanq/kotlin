import enums.Quality

fun main() {
    ifConditions()
    whenConditions()
}

fun ifConditions() {

    val score = 80
    if (score > 50) {
        println("Passed")
    } else {
        println("Failed")
    }

    if (score > 50) println("Passed") else if (score == 50) println("Just Passed") else println("Failed")

    val isPassed = if (score > 50) true else false
    println(isPassed)

    val isPassed2 = if (score > 50) {
        println("Passed")
        "I love you very much" //last line is the return value
    } else {
        println("Failed")
        false
    }
    println(isPassed2)

}

fun whenConditions() {
    val quality: Quality = Quality.GOOD
    val qualityMessage: String = when (quality) {
        //when = switch-case
        Quality.BAD -> "This is bad"
        Quality.NORMAL -> "Quality is normal"
        Quality.GOOD -> "Yes, it is Good"
        Quality.EXCELLENT -> "Wooo, excellent"
    }
    println(qualityMessage)

    val score = 80
    when (score) {
        in 0..50 -> println("Failed")
        in 51..70 -> println("Normal")
        in 71..90 -> {
            println("Good")
            println("Keep it up")
        }

        in 91..100 -> println("Excellent")
        else -> println("Invalid score")
    }

    when (score) {
        1, 4, 5 -> println("One")
        in 2..10 -> println("From 2 to 10")
        !in 10..20 -> println("Not in 10 to 20")
        80 -> {
            println("Eighty")
            println("Keep it up")
        }

        else -> println("Invalid score")
    }

    //If your when expression doesn't have a subject, you must have an else branch or the compiler throws an error. 
    // The else branch is evaluated when none of the other branch conditions are satisfied:
    when {
        score > 50 -> println("Passed")
        score == 50 -> println("Just Passed")
        else -> println("Failed")
    }

}