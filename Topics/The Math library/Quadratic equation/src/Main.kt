import kotlin.math.*

fun main() {
    val a = readLine()!!.toDouble()
    val b = readLine()!!.toDouble()
    val c = readLine()!!.toDouble()

    val x1 = (-b + sqrt(b * b - 4 * a * c)) / (2 * a)
    val x2 = (-b - sqrt(b * b - 4 * a * c)) / (2 * a)

    if (x1 < x2) {
        println("$x1 $x2")
    } else {
        println("$x2 $x1")
    }
}