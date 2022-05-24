class Rectangle(val width: Int, val height: Int)

fun printArea(rectangle: Rectangle) {
    val product = rectangle.height * rectangle.width
    println(product)
}