package models

class Bicycle(
    name: String,
    year:Int,
    private var hasBasket: Boolean
) :Vehicle(name, year) {
    override fun toString(): String = "${super.toString()}, hasBasket: $hasBasket"

    fun setHasBasket(hasBasket: Boolean) {
        this.hasBasket = hasBasket
    }
    
}