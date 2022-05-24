import kotlin.math.pow

fun main() {
    val commonName = readLine()!!
    val commonValue = readLine()!!.toInt()
    val result = when (commonName) {
        "amount" -> getFinalAmount(amount = commonValue)
        "percent" -> getFinalAmount(percent = commonValue)
        "years" -> getFinalAmount(years = commonValue)
        else -> throw Exception("Unknown arg $commonName")
    }
    println(result)
}

fun getFinalAmount(amount: Int = 1000, percent: Int = 5, years: Int = 10) =
    (amount.toDouble() * (1 + percent.toDouble()/100).pow(years.toDouble())).toInt()