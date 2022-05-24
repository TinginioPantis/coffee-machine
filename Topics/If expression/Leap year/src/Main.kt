fun main() {
    val year = readLine()!!.toInt()
    if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
        println("Leap")
    } else println("Regular")
}