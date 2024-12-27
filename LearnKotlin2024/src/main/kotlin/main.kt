import collections.*
import enums.RequestError
import models.Bicycle
import models.*
import utilities.Calculation

fun main() {

    /***Data Types***/
    getDataType()
    /***Data Types***/
    
    val requestError: RequestError = RequestError.SUCCESS
    println(requestError)
    println(requestError.message)
    println(requestError.wordCount())
    //define a key-value object
    var person1 = object {
        var name = "Hoang"
        var emailAddress = "sunlight4d@gmail.com"
        var age = 18
        override fun toString(): String =
            "name:$name, email:$emailAddress, age:$age"
    }
    println(person1)
    val person2 = mutableMapOf<String, Any>(
        "name" to "John",
        "email" to "john@gmail.com",
        "age" to 22
    )
    person2["email"] = "john123@gmail.com" //you can change if person2 is a "mutable map"
    person2["age"] = 18
    println(person2)
    //companion object => like "static"
    println(Calculation.multiply(2, 5))
    println("PI = ${Calculation.PI}")
    //Sealed types cannot be instantiated => it is "abstract"
    //val vehicle:Vehicle = Vehicle("haha", 2022)
    val bicycle: Bicycle = Bicycle("vihaha", 2022, hasBasket = true)
    println(bicycle)
    val car1: Car = Car("GLB 200 7G-DCT", 2020, 81.3f, horsePower = 163)
    println(car1)
//    println(car1.name)
//    println(car1.horsePower)

    var bike = Bike("Giant", 2021, hasBasket = false)
    with(bike) {
        println("Bike name: $name, year: $year, hasBasket: ${isHasBasket()}")
    }

    var bus = Bus("Mercedes", 2020, 50)
    var electricBike = ElectricBike("Tesla", 2022, 100)
    println("Bike : $bike, Bus : $bus, ElectricBike : $electricBike")

    with(car1) {
        //print other fields here
        println(horsePower) //163
    }
    //you can update multiple properties here
    bicycle.apply {
        year = 2020
        //hasBasket = false, error because hasBasket is private
        setHasBasket(false) //use manually setter
    }
    println(bicycle)
    //check object type
    println(describeVehicle(vehicle = car1))
    car1.run(112.3) //extension function: add a new function to an existing class

    /***List***/
    println("Demo List")

    immutableList()
    mutableList()
    listMixed()
    manipulationList()
    createEmptyList()
    nestedList()
    convertListType()
    /***List***/

    /***String Manipulation***/
    stringManipulation()
    /***String Manipulation***/
}