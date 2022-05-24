import kotlin.math.*

fun main() {
    val input = readLine()!!.toDouble()
    val result = (input * 10).toInt() % 10
    println(result)
}