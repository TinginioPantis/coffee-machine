// complete this function, add default values
fun carPrice(old: Int = 5, kilometers: Int = 100000, maximumSpeed: Int = 120, automatic: Boolean = false): Int {
    val ageDiscount = old * 2000
    val distanceDiscount = kilometers / 10000 * 200
    val speedModifier = (maximumSpeed - 120) * 100
    val automaticPremium = if (automatic) 1500 else 0

    val price = 20000 - ageDiscount - distanceDiscount + speedModifier + automaticPremium
    println(price)
    return price
}
//
//fun main() {
//    println(carPrice(old = 1, kilometers = 10000, maximumSpeed = 130))
//}