fun main() {
    val actualSpeed = readLine()!!.toInt()
    var limit = readLine()!!
    if (limit == "no limit") {
        limit = "60"
    } else limit.toInt()
    println(
        if (actualSpeed > limit.toInt()) {
            "Exceeds the limit by ${actualSpeed - limit.toInt()} kilometers per hour"
        } else "Within the limit"
    )

//    fun checkSpeed(speed: Int, speedLimit: String = "no limit") {
//        val speedLimitNumber: Int = if (speedLimit == "no limit") 60 else speedLimit.toInt()
//        val excess = speed - speedLimitNumber
//
//        print(if (excess > 0) "Exceeds the limit by $excess kilometers per hour" else "Within the limit")
//    }
}