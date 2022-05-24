import kotlin.math.sqrt

fun main() {
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val c = readLine()!!.toInt()
    val p = (a + b + c.toDouble()) / 2
    val s = sqrt(p * (p - a) * (p - b) * (p - c))
    println(s)

}