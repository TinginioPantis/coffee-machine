import kotlin.math.max

fun main() {
    val v1 = readLine()!!.toInt()
    val v2 = readLine()!!.toInt()
    val v3 = readLine()!!.toInt()
    val v4 = readLine()!!.toInt()

    val maxOfFour = max(max(v1, v2), max(v3, v4))
    println(maxOfFour)
}
