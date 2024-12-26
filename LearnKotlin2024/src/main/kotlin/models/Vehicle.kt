package models
//sealed is "abstract" => cannot create object from it
//but it can be inherited, not inherit multiple levels
sealed class Vehicle(var name: String, var year:Int) {
    override fun toString(): String = "name:$name, year:$year"
    
    /*
     Long hang way to re-write the above code 
     override fun toString(): String {
        return "name:$name, year:$year"
     }
    */

}

open class Bike(name: String, year: Int, private var hasBasket: Boolean): Vehicle(name, year) {
    override fun toString(): String = "${super.toString()}, hasBasket:$hasBasket"
    
    fun isHasBasket(): Boolean = hasBasket
    
}

class Bus(name: String, year: Int, var capacity: Int): Vehicle(name, year) {
    override fun toString(): String = "${super.toString()}, capacity:$capacity"
}

// if you want to inherit from a class, you must use "open" keyword (if not use open the class is final)
class ElectricBike(name: String, year: Int, var batteryCapacity: Int): Bike(name, year, hasBasket = true) {
    override fun toString(): String = "${super.toString()}, batteryCapacity:$batteryCapacity"
}