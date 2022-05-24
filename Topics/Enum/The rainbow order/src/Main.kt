enum class Rainbow(val color: String) {
    RED("Red"),
    ORANGE("Orange"),
    YELLOW("Yellow"),
    GREEN("Green"),
    BLUE("Blue"),
    INDIGO("Indigo"),
    VIOLET("Violet")
}

fun main() {
    val input = readLine()!!.uppercase()
    val color: Rainbow = Rainbow.valueOf(input)
    println(color.ordinal+1)
}