import com.sun.source.doctree.AttributeTree.ValueKind

fun main(){
    nullable()
}

fun nullable(){
    var name: String = "Denis" //non-nullable
    //name = null //Compile error
    
    var email: String? = "Hoang" //nullable, optional, default variable are not null
    email = "hoang@gmail.com"
//    email = null
    
    val student: Student? = null //nullable
    
    val student2: Student? = Student("1", "Hoang") 
    //'student2' is always non-null type, IDE yield to remove '?' to make it non-null
    //student2 = null //Compile error, val cannot be reassigned
    
    var student3: Student? = Student("1", "Hoang")
    student3 = null //OK, var can be reassigned
    
    //if student3 is null, then let block will not be executed
    student3?.let { 
        println("student3 is not null")
        for (i in 1..5) {
            println(i)
        }
        when(student3.name) {
            "Hoang" -> println("Hoang is here")
            else -> println("Someone else")
        }
    }
    
    //Elvis operator ?:
    //first operand ?: second operand
    //If first operand isn't null, then it will be returned. 
    // If it is null, then the second operand will be returned. 
    // This can be used to guarantee that an expression won't return a null value, as you'll provide a non-nullable value if the provided value is null.
    println("email's length is : ${email?.length ?: 0}")
    //if email is null then return 0, because failing back to the second operand
    //but if email is not null then email can use length property and then return the length of that email fail back to the first operand
    
    //if email is null, then return null, else return length, in-case the result are null then take the default value is 0
    println("email = ${email ?: "someone@gmail.com"}") //default value
    
    //Not null assertion operator !!
    //If you're sure that a nullable variable isn't null, you can use the not-null assertion operator (!!) to return a non-nullable value.
    //If the variable is null, a NullPointerException will be thrown.
    println("email's : ${email!!.uppercase()}") //NullPointerException
}