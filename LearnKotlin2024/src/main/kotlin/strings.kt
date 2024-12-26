fun stringManipulation() {

    val s = "Hello, world!\n"

    val text = """
    for (c in "foo")
        print(c)
    """

    val content = """
    |Tell me and I forget.
    |Teach me and I remember.
    |Involve me and I learn.
    |(Benjamin Franklin)
    """.trimMargin()

    val contentV2 = """
    ?   Tell me and I forget.
    ?   Teach me and I remember.
    ?   Involve me and I learn.
    ?   (Benjamin Franklin)
    """.trimMargin("?")

    //template string - string interpolation
    val letters = listOf("a", "b", "c", "d", "e")
    println("Letters: $letters")

    val hehehe = "abc"
    println("$hehehe.length is ${s.length}")

    println(s)
    println(text)
    println(content)
    println(contentV2)

}

fun stringFormat() {
    // Formats an integer, adding leading zeroes to reach a length of seven characters
    val integerNumber = String.format("%07d", 31416)
    println(integerNumber)
    // 0031416

    // Formats a floating-point number to display with a + sign and four decimal places
    val floatNumber = String.format("%+.4f", 3.141592)
    println(floatNumber)
    // +3.1416

    // Formats two strings to uppercase, each taking one placeholder
    val helloString = String.format("%S %S", "hello", "world")
    println(helloString)
    // HELLO WORLD

    // Formats a negative number to be enclosed in parentheses, then repeats the same number in a different format (without parentheses) using `argument_index$`.
    val negativeNumberInParentheses = String.format("%(d means %1\$d", -31416)
    println(negativeNumberInParentheses)
    //(31416) means -31416
}