import kotlin.math.*

fun main() {
    val input = readLine()!!.toDouble()
//    val result = input.pow(1/3).roundToInt()
    val result = Math.cbrt(input).toInt()
    println(result)
}