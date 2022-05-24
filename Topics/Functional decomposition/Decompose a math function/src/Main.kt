import kotlin.math.pow

fun f(x: Double): Double {
    return when {
        x <= 0 -> f1(x)
        0 < x && x < 1 -> f2(x)
        else -> f3(x)
    }
}

// implement your functions here
fun f1(x: Double): Double {
    return x.pow(2) + 1
}

fun f2(x: Double): Double {
    return 1 / x.pow(2)
}

fun f3(x: Double): Double {
    return x.pow(2) - 1
}